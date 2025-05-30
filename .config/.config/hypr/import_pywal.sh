#!/bin/bash

colors_file="$HOME/.cache/wal/colors"

readarray -t colors < "$colors_file"

color_set="${colors[3]#"#"}"

cat <<EOF > "$HOME/.config/hypr/pywal_colors.conf"
general {
    col.active_border = rgba(${color_set}dd)
}
EOF
