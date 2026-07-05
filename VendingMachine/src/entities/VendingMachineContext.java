package entities;

import enums.VendingMachineState;

public class VendingMachine {
    private static VendingMachine machine;
    private final Inventory inventory = new Inventory();
    private VendingMachineState currentState;
    private int balance;

    private VendingMachine() {
        this.currentState = VendingMachineState.Idle;
    };

    public VendingMachine getVendingMachine() {
        if(machine == null) {
            machine = new VendingMachine();
        }
        return machine;
    }

    public void addItemToInventory(String code, Item item) {};

    public void removeItemFromInventory(String code) {};

    public void addItemToCart(String code) {};

    public void removeItemFromCart(String code) {};

    public void goToCart() {};

    public void makePayment() {};

    private void dispense() {};
}
