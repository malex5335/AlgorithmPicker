# Random Algorithm picker

This is a simple spring application that picks some random algorithms from a list of algorithms.

## How to run

### Native

1. Clone the repository
2. Start the Spring application
3. Open `localhost:8080` in your browser
4. Refresh the page every day to get new algorithms to learn
5. Enjoy!
6. If you want to add more algorithms, add them to the `/src/main/resources/algorithms.json` file

### With Docker-Compose

1. Clone the repository
2. Run `docker-compose up -d`
3. Open `localhost:8080` in your browser
4. Refresh the page every day to get new algorithms to learn
5. Enjoy!
6. If you want to add more algorithms, add them to the `/src/main/resources/algorithms.json` file
   - run `docker-compose restart --build` to restart the application

### With Kubernetes

1. Copy `kubernetes.yaml` to your Kubernetes cluster
2. Run `kubectl apply -f kubernetes.yaml`
3. Open the app in your browser using the LoadBalancer IP
4. Refresh the page every day to get new algorithms to learn
5. Enjoy!

## How the Rest API works

1. Open `localhost:8080` in your browser
2. The URI will display algorithms of a certain category
   - i.e. `/sorting/` will pick a random algorithm from the sorting category
   - leave empty or use `/all/` to pick from all algorithms
3. Add parameter `amount` to increase or decrease the number of algorithms
   - i.e. `/sorting/?amount=5` will pick 5 random sorting algorithms
   - the default amount is 3
   - will display up to the number of algorithms in the category
   - no duplicate algorithms will be picked this way
4. The random algorithms will change based on the current date
   - i.e. if you refresh the page at 11:59 PM, the algorithms will not have changed
   - if you refresh the page at 12:00 AM, the algorithms will change