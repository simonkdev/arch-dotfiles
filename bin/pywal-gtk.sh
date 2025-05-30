#!/bin/bash

# Check if pywal is installed
if ! command -v wal &> /dev/null
then
    echo "pywal not found! Please install pywal first."
    exit 1
fi

# Check if oomox is installed
if ! command -v oomox-cli &> /dev/null
then
    echo "oomox-cli not found! Please install oomox first."
    exit 1
fi

# Generate colors from pywal
#wal -q

# Extract the colors from the pywal-generated colorscheme
BACKGROUND=$(cat ~/.cache/wal/colors.json | jq -r '.background')
FOREGROUND=$(cat ~/.cache/wal/colors.json | jq -r '.foreground')
COLOR1=$(cat ~/.cache/wal/colors.json | jq -r '.color0')
COLOR2=$(cat ~/.cache/wal/colors.json | jq -r '.color1')
COLOR3=$(cat ~/.cache/wal/colors.json | jq -r '.color2')
COLOR4=$(cat ~/.cache/wal/colors.json | jq -r '.color3')
COLOR5=$(cat ~/.cache/wal/colors.json | jq -r '.color4')
COLOR6=$(cat ~/.cache/wal/colors.json | jq -r '.color5')
COLOR7=$(cat ~/.cache/wal/colors.json | jq -r '.color6')
COLOR8=$(cat ~/.cache/wal/colors.json | jq -r '.color7')

# Create the GTK theme directory if it doesn't exist
THEME_DIR="$HOME/.themes"
if [ ! -d "$THEME_DIR" ]; then
    mkdir -p "$THEME_DIR"
fi

# Set the theme name (you can modify this for your custom theme name)
THEME_NAME="thunar-pywal-theme"

# Set the Oomox theme directory (make sure it's installed)
OOMOX_THEME_DIR="$HOME/.config/oomox/themes"

# Ensure Oomox theme directory exists
if [ ! -d "$OOMOX_THEME_DIR" ]; then
    mkdir -p "$OOMOX_THEME_DIR"
fi

# Path to Oomox's theme preset (update to a valid path)
PRESET_PATH="/opt/oomox/colors/Modern"  # Adjust to your Oomox preset path, e.g., adapta or clearlooks

# Apply pywal colors to the preset using Oomox
if [ -d "$PRESET_PATH" ]; then
    /opt/oomox/plugins/theme_oomox/change_color.sh -o "$THEME_NAME" -t "$OOMOX_THEME_DIR" "$PRESET_PATH"
else
    echo "Preset path not found: $PRESET_PATH"
    exit 1
fi

# Copy the generated theme to the themes folder
cp -r "$OOMOX_THEME_DIR/$THEME_NAME" "$THEME_DIR"

# Set the new GTK theme
gsettings set org.gnome.desktop.interface gtk-theme "$THEME_NAME"

# Set the Thunar theme (this assumes Thunar uses GTK themes)
xfconf-query -c xsettings -p /Net/ThemeName -s "$THEME_NAME" --create

echo "Thunar GTK theme set to $THEME_NAME based on pywal colors!"
