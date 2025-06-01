class Solution {
    class Car {
        int pos, speed;
        Car(int p, int s) {
            this.pos = p;
            this.speed = s;
        }
    }

    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        List<Car> cars = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            cars.add(new Car(position[i], speed[i]));
        }

        
        cars.sort((a, b) -> b.pos - a.pos);

        Stack<Double> st = new Stack<>();

        for (Car car : cars) {
            double time = (double) (target - car.pos) / car.speed;
            if (st.isEmpty() || time > st.peek()) {
                st.push(time);
            }
        }

        return st.size(); 
    }
}
