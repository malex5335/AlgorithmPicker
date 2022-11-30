# Random Algorithm picker

This is a simple spring application that picks some random algorithms from a list of algorithms.

## How to run

1. Clone the repository
2. Start the Spring application
3. Open `localhost:8080` in your browser
4. Refresh the page every day to get new algorithms to learn
5. Enjoy!
6. If you want to add more algorithms, add them to the `/src/main/resources/algorithms.json` file

## How to use

1. Open `localhost:8080` in your browser
2. The URI will display algorithms of a certain category
   - i.e. `/sorting/` will pick a random sorting algorithm
   - leave empty or use `/all/` to use all algorithms
3. Add parameter `?amount=5` to the URI to get 5 algorithms
   - i.e. `/sorting/?amount=5` will pick 5 random sorting algorithms
   - the default amount is 3
   - the maximum amount depends on the amount of algorithms in the category
4. The random algorithms will only change after midnight
   - i.e. if you refresh the page at 11:59 PM, the algorithms will not change
   - if you refresh the page at 12:00 AM, the algorithms will change