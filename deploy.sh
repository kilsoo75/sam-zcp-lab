
cd docs/.vuepress/dist
git init
git add -A
git commit -m deploy

git push https://github.com/myguddy/sam-k8s-lab.git master:gh-pages   