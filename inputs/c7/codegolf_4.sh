#!/bin/bash

read -d '' ARG0 <<"EOF"
bashscript.sh
EOF

read -d '' ARG1 <<"EOF"
2:2|1:5
3:8|1:0
4:2|1:5|2:0
1:1|2:0|4:2
2:0|2:7
1:0|1:8
1:5|3:6|1:0
1:1|1:3|2:5
EOF

read -d '' ARG2 <<"EOF"
2
EOF



read -d '' SCRIPT <<"EOF"
CODEGOLF_METHOD_PLACEHOLDER

EOF


/bin/bash -c "$SCRIPT"  "$ARG0" "$ARG1" "$ARG2"

