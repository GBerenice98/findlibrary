cd src/main/java/miage/findlibrary/frontend
echo "1/4 - Building project …"
sudo ng build --prod
echo "---- Build finished."
echo "2/4 -Creating docker image"
sudo docker build -t findlibrary-front .
echo "---- Docker image created."
sudo docker container rm -f findlibrary-front
echo "3/4 -Current container removed."
sudo docker run --name findlibrary-front -d -p 4200:80 findlibrary-front
echo "4/4 -New container created."
