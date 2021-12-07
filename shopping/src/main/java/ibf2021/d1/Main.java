package ibf2021.d1;

import java.util.*;

public class Main {
    // test
    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            ArrayList<String> cartList = new ArrayList<>();
            System.out.println("Welcome to your shopping cart");
            boolean keepInput = true;
            String toAdd;
            int toDelete;
            String[] command = new String[]{"add", "delete", "list", "exit"};
            List<String> commandArray = Arrays.asList(command);

            System.out.println("Please type add/delete for your shopping cart, type list to check, or exit.");
            while (keepInput) {

                // toLowerCase() makes all input to lower case
                String userInput = input.next().toLowerCase();
                input.nextLine();
                //check if valid input do
                if (!commandArray.contains(userInput.trim())){
                    System.out.println("Your command is invalid, please enter correct command.");
                    System.out.println("Please type add/delete for your shopping cart, type list to check, or exit.");
                }
                else{
                    // check input for list, print cart empty or have any items, use trim() to remove the space may be entered
                    if (userInput.trim().equals("list")) {
                        if (cartList.isEmpty()) {
                            System.out.println("Your cart is empty");
                        } else {
                            for (int i =0 ;i < cartList.size(); i++){
                                System.out.printf("%d. %s \n", i + 1,cartList.get(i));
                            }
                        }
                        System.out.println("Please type add/delete for your shopping cart, type list to check, or exit.");
                    }

                    // check input for add
                    if (userInput.trim().equals("add")) {
                        System.out.println("Please add items");
                        String addItems = input.nextLine().toLowerCase();
                        String [] arrOfAdd = addItems.split(" ", 10);
                        for (int i = 1; i < arrOfAdd.length; i++){
                            toAdd = arrOfAdd[i].trim().replace(",", "");
                            // check if toAdd is already in cart
                            if (cartList.contains(toAdd)){
                                System.out.printf("%s is already in the cart \n", toAdd);
                            }
                            else{
                                cartList.add(toAdd);
                            }
                        }
                        System.out.println("Please type add/delete for your shopping cart, type list to check, or exit.");
                    }

                    // check input for delete
                    if (userInput.trim().contains("delete")){
                        System.out.println("Please delete items");
                        String deleteItem = input.nextLine().toLowerCase();
                        toDelete = Integer.parseInt(deleteItem.replace("delete ", "").trim());
                        // check if the index is out of the cart list
                        if (toDelete > cartList.size()){
                            System.out.println("Incorrect item index");
                        }

                        // else remove the correct item from cart list, print the message for item removed
                        else{
                            System.out.printf("%s is removed from cart \n", cartList.get(toDelete - 1));
                            cartList.remove(toDelete - 1);
                        }
                        System.out.println("Please type add/delete for your shopping cart, type list to check, or exit.");
                    }

                    // check input for exit
                    if (userInput.trim().equals("exit")){
                        keepInput = false;
                    }
                }

                }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        }
        }