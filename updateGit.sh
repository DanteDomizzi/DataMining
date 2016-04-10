DATE=`date +%Y-%m-%d:%H:%M:%S`

git status
git add .
git status
git commit -m $DATE
git push origin master

