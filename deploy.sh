#!/usr/bin/env sh

# abort on errors
set -e
# build vuepress
yarn docs:build

cd docs/.vuepress/dist
git init
git add -A
git commit -m deploy

<<<<<<< HEAD
git push -f https://github.com/myguddy/sam-k8s-lab.git master:gh-pages

cd -
=======
git push -f https://github.com/myguddy/sam-k8s-lab.git master:gh-pages   
>>>>>>> documentation
