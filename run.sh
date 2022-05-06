### Andr7st
# unlock this script chmod +x run.sh
### '#!' Shebang
#!/bin/bash 
# -*- ENCODING: UTF-8 -*-

## Checking if maven is intalled:
echo -e "\033[31m\033[1mThis is a spring-boot-project by Andr7st\033[0m"

if ! [ -x "$(command -v mvn)" ] &&  [ -x "$(command -v java)" ]; then
  echo "java & maven needed for run this." >&2
  exit 1
fi
## Alternative code:
##command -v mvn >/dev/null 2>&1 || { echo "Error: ${programa} is not installed." >&2; exit 1; }
echo -e ""
mvn --version

echo -e ""
java --version

echo " "
# pause/seconds.
sleep 3s; clear

#echo $(date +%Y-%m-%d_%H%M%S)

# run the app:
mvn spring-boot:run

# Script crated by Andr7st.