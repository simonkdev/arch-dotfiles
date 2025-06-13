#!/bin/bash
set -e

REPO_DIR="$HOME/dotfiles"
GITHUB_URL="git@github.com:simonkdev/arch-dotfiles.git"

# Cleanup
rm -rf "$REPO_DIR"
mkdir -p "$REPO_DIR"

echo "[+] Saving package lists..."
pacman -Qqe > "$REPO_DIR/pkglist.txt"
comm -23 <(pacman -Qqm | sort) <(pacman -Qq | sort) > "$REPO_DIR/aurlist.txt"

echo "[+] Copying configs..."
rsync -a --exclude '*/Cache' --exclude '*/cache' ~/.config "$REPO_DIR/.config"
rsync -a --exclude '*/Cache' --exclude '*/cache' ~/.local "$REPO_DIR/.local"

echo "[+] Copying user bin..."
[ -d "$HOME/bin" ] && cp -a "$HOME/bin" "$REPO_DIR/bin"

echo "[+] Copying dotfiles..."
shopt -s dotglob
cp -a ~/.bashrc ~/.zshrc ~/.xinitrc ~/.Xresources ~/.profile ~/.bash_profile "$REPO_DIR/" 2>/dev/null || true
shopt -u dotglob

echo "[+] Copying /etc configurations..."
mkdir -p "$REPO_DIR/etc"
cp -a /etc/{pacman.conf,mkinitcpio.conf,fstab,locale.gen,hostname,hosts,issue,os-release} "$REPO_DIR/etc/" 2>/dev/null || true
cp -a /etc/systemd "$REPO_DIR/etc/systemd" 2>/dev/null || true
cp -a /etc/X11 "$REPO_DIR/etc/X11" 2>/dev/null || true
cp -a /etc/lightdm "$REPO_DIR/etc/lightdm" 2>/dev/null || true
cp -a /etc/xdg/waybar "$REPO_DIR/etc/xdg/waybar" 2>/dev/null || true

# .gitignore for common large/cache files
cat <<EOF > "$REPO_DIR/.gitignore"
*.cache
.cache/
*.log
.local/share/Steam/
.local/share/flatpak/
.local/share/Trash/
EOF

cd "$REPO_DIR"
git init
git remote add origin "$GITHUB_URL"
git branch -M main

### 🔁 Chunked Uploads to Stay Under 2GB ###

echo "[+] Committing and pushing pkglist..."
git add pkglist.txt aurlist.txt
git commit -m "Add package lists"
git push -f origin main

echo "[+] Committing and pushing dotfiles..."
for f in .bashrc .zshrc .xinitrc .Xresources .profile .bash_profile; do
    [ -f "$f" ] && git add "$f"
done
git commit -m "Add dotfiles"
git push origin main

echo "[+] Committing and pushing ~/.config..."
git add .config
git commit -m "Add .config"
git push origin main

echo "[+] Committing and pushing bin..."
git add bin
git commit -m "Add user scripts"
git push origin main

echo "[+] Committing and pushing /etc..."
git add etc
git commit -m "Add selected /etc configs"
git push origin main

echo "[✓] Backup complete. All chunks pushed to GitHub."

