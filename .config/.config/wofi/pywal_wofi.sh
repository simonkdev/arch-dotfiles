#!/bin/bash

# Path to Pywal's generated colors.css
colors_css_path="/home/simonkdev/.cache/wal/colors.css"

# Check if colors.css exists
if [[ ! -f "$colors_css_path" ]]; then
  echo "Error: $colors_css_path does not exist."
  exit 1
fi

# Read colors.css and extract the color variables
declare -A colors
while IFS=': ' read -r name value; do
  if [[ "$name" =~ --color[0-9]+ ]]; then
    colors["$name"]="${value//;/}"
  fi
done < "$colors_css_path"

# Generate the new style.css with the Pywal colors injected
cat << EOF > /home/simonkdev/.config/wofi/style.css
/* Catppuccin Macchiato Theme with Mauve Accent for Wofi */

/* Main window with gradient border AND rounded corners */
window {
    font-family: "Aurebesh", "JetBrainsMono Nerd Font", sans-serif;
    font-size: 14px;
    background-color: transparent;
    color: ${colors[--color2]}; /* Corresponds to --color7 */
    border: double 0px transparent;
    border-radius: 15px;
    background-image: linear-gradient(${colors[--color0]}, ${colors[--color0]}), 
                      linear-gradient(to bottom, ${colors[--color3]}, ${colors[--color9]}); /* Corresponds to --color7 and --color4 */
    background-origin: border-box;
    background-clip: content-box, border-box;
    opacity: 0.49;
}

/* Input field */
#input {
    margin: 8px;
    padding: 8px 12px;
    background-color: rgba(24, 24, 37, 0.7);  /* More transparent input */
    color: ${colors[--color7]}; /* Corresponds to --color3 */
    border: 1px solid ${colors[--color3]}; /* Corresponds to --color3 */
    border-radius: 8px;
}

#input:focus {
    border: 1px solid ${colors[--color2]}; /* Corresponds to --color13 */
}

/* Search results */
#outer-box {
    margin: 8px;
    padding: 0px;
    background-color: transparent;
}

#inner-box {
    margin: 0px;
    padding: 0px;
    background-color: transparent;
}

/* List items */
#entry {
    padding: 8px 12px;
    border-radius: 6px;
    margin: 2px 0;
    background-color: rgba(24, 24, 37, 0.5);  /* Transparent list items */
}

#entry:selected {
    background-color: ${colors[--color8]};  /* Slightly less transparent when selected */
    border-left: 4px solid ${colors[--color7]}; /* Corresponds to --color13 */
}

/* Text inside entries */
#text {
    margin: 0 8px;
    color: ${colors[--color7]}; /* Corresponds to --color6 */
}

#text:selected {
    color: ${colors[--color0]}; /* Corresponds to --color13 */
}

/* Application icon */
#img {
    margin-right: 8px;
}

/* Scrollbar */
#scroll {
    margin: 0 4px;
}

scrollbar {
    background-color: rgba(30, 30, 46, 0.5);
    border-radius: 8px;
}

scrollbar slider {
    background-color: rgba(69, 71, 90, 0.7);
    border-radius: 8px;
    margin: 2px;
}

scrollbar slider:hover {
    background-color: ${colors[--color13]}; /* Corresponds to --color13 */
}
EOF

echo "style.css has been generated with Pywal colors."
