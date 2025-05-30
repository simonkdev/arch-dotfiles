#!/bin/bash
set -e

REPO_DIR="$HOME/dotfiles"
GITHUB_URL="git@github.com/simonkdev/arch-dotfiles.git"

echo "[+] Cloning dotfiles repo..."
git clone "$GITHUB_URL" "$REPO_DIR"
cd "$REPO_DIR"

echo "[+] Installing packages from pkglist.txt..."
sudo pacman -Syu --needed --noconfirm - < pkglist.txt

if command -v yay &>/dev/null; then
    echo "[+] Installing AUR packages..."
    yay -S --needed --noconfirm - < aurlist.txt
else
    echo "[!] Skipping AUR packages (yay not found)."
fi

echo "[+] Restoring user config directories preserving structure..."
cp -a "$REPO_DIR/.config" "$HOME/"
cp -a "$REPO_DIR/.local" "$HOME/"

echo "[+] Restoring user bin directory..."
if [ -d "$REPO_DIR/bin" ]; then
    cp -a "$REPO_DIR/bin" "$HOME/"
fi

echo "[+] Restoring user dotfiles..."
shopt -s dotglob
cp -a "$REPO_DIR"/.* "$HOME/" 2>/dev/null || true
shopt -u dotglob

echo "[+] Restoring system config files preserving structure..."
sudo cp -a "$REPO_DIR/etc/"* /etc/

echo "[✓] Restore complete. You may want to reboot and rebuild initramfs if needed."
