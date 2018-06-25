#!/bin/bash

read -d '' ARG0 <<"EOF"
bashscript.sh
EOF

read -d '' ARG1 <<"EOF"
12
EOF

read -d '' ARG2 <<"EOF"
apple
EOF

read -d '' ARG3 <<"EOF"
3.14
EOF

read -d '' ARG4 <<"EOF"
/challenge_input/c0/input1.txt
EOF

read -d '' ARG5 <<"EOF"
a
EOF

read -d '' ARG6 <<"EOF"
3
EOF



read -d '' SCRIPT <<"EOF"
CODEGOLF_METHOD_PLACEHOLDER

EOF


/bin/bash -c "$SCRIPT"  "$ARG0" "$ARG1" "$ARG2" "$ARG3" "$ARG4" "$ARG5" "$ARG6"

