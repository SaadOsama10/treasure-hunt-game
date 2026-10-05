#!/bin/sh
# Builds docs/play/treasure.jar for the browser (CheerpJ runs Java 8/11/17, so compile with --release 11).
set -e
cd "$(dirname "$0")"
rm -rf build/web && mkdir -p build/web
javac --release 11 -d build/web src/testgame/*.java
cp -R src/testgame/images build/web/testgame/
printf 'Main-Class: testgame.ZeineddinRadiMain\n' > build/web/MANIFEST.MF
jar cfm docs/play/treasure.jar build/web/MANIFEST.MF -C build/web testgame
echo "built docs/play/treasure.jar"
