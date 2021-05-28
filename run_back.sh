echo "1/3 -Creating docker image"
sudo docker build -t findlibrary-app .
echo "---- Docker image created."
sudo docker container rm -f findlibrary-app
echo "2/3 -Current container removed."
sudo docker run --name findlibrary-app -d -p 8085:8085 --network="bridge" findlibrary-app
echo "4/4 -New container created."
