#!/usr/bin/env sh

# abort on errors
set -e
# build vuepress
yarn docs:build

cd docs/.vuepress/dist
git init
git add -A
git commit -m deploy

git push -f https://github.com/cnpst/sam-zcp-lab.git master:gh-pages

cd -

