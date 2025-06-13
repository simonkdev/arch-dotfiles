#
# ~/.bashrc
#

# If not running interactively, don't do anything
[[ $- != *i* ]] && return

alias ls='ls --color=auto'
alias grep='grep --color=auto'
alias kde='startx /usr/bin/startplasma-x11'
alias walfetchkde='wal -i ~/wallpapers/frappa-wallp.jpg'
alias win11='xfreerdp3 /u:"simonkdev" /p:"1205" /v:127.0.0.1 /cert:tofu'


PS1='[\u@\h \W]\$ '

source ~/.cache/wal/colors.sh
export JAVA_HOME=/usr/lib/jvm/java-24-openjdk
export PATH=$JAVA_HOME/bin:$PATH
export PATH=/home/simonkdev/bin/pywal:$PATH
export PATH=/home/simonkdev/bin:$PATH
export EDITOR=nano
export NNN_OPTS=H
export PATH=/home/simonkdev/.local/bin:$PATH
export PATH=/root/.local/bin:$PATH
