class ParkingSystem {
    int[] slots;

    public ParkingSystem(int big, int medium, int small) {
        slots = new int[]{big,medium,small};
    }

    public boolean addCar(int carType) {
        if(slots[carType - 1] < 1) return false;
        slots[carType - 1]--;
        return true;
    }

    public static void main(String[] args) {
        ParkingSystem p = new ParkingSystem(2, 3, 1);
        p.addCar(1);
        //p.addCar(2);
        p.addCar(1);
        p.addCar(1);
        p.addCar(1);
        p.addCar(1);
    }
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */