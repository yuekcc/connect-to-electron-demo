all: browser selenium-demo
    @echo "done"

browser:
    #!/bin/sh
    cd browser
    npm i
    npm run build

selenium-demo:
    #!/bin/sh
    cd selenium-demo
    mvn clean package
