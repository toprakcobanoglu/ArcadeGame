package java102.arcadeGame;

public class Store extends NormalLocation {
    public Store(Player player) {
        super(player, "Store");
    }

    @Override
    public boolean onLocation() {
        System.out.println("Welcome to the store");
        boolean showMenu = true;
        while (showMenu) {
            System.out.println("1- Weapons");
            System.out.println("2- Armors");
            System.out.println("3- Exit");
            int selectCase = Location.scan.nextInt();
            while (selectCase < 1 || selectCase > 3) {
                System.out.println("Re-enter your selection please!");
                selectCase = scan.nextInt();
            }
            switch (selectCase) {
                case 1:
                    printWeapon();
                    buyWeapon();
                    break;
                case 2:
                    printArmor();
                    buyArmor();
                    break;
                case 3:
                    System.out.println("Bye Bye!!");
                    System.out.println("Bye Bye!!");
                    showMenu = false;
                    break;

            }
        }
        return true;
    }

    public void printWeapon() {
        System.out.println("-------WEAPONS-------");
        System.out.println();
        for (Weapons w : Weapons.weapons())
            System.out.println(w.getId() + " - " + w.getName() + " Price: " + w.getCost() + " Damage: " + w.getDamage());
        System.out.println("0 - Exit");
    }

    public void buyWeapon() {
        System.out.println("Select a weapon");
        int selectWeaponID = scan.nextInt();
        while (selectWeaponID < 0 || selectWeaponID > Weapons.weapons().length) {
            System.out.println("Re-enter your selection please!");
            selectWeaponID = scan.nextInt();
        }
        if (selectWeaponID != 0) {
            Weapons selectedWeapon = Weapons.getWeaponObjByID(selectWeaponID);

            if (selectedWeapon != null)
                if (selectedWeapon.getCost() > this.getPlayer().getCoin()) System.out.println("Not enough coin");
                else {
                    //Satın almanın gerçekleştiği alan
                    System.out.println("Purchase this weapon : " + selectedWeapon.getName());
                    int balance = this.getPlayer().getCoin() - selectedWeapon.getCost();
                    this.getPlayer().setCoin(balance);
                    System.out.println("Your remaining coin: " + this.getPlayer().getCoin());
                    System.out.println("Your last weapon is: " + this.getPlayer().getInventory().getWeapons().getName());
                    this.getPlayer().getInventory().setWeapons(selectedWeapon);
                    System.out.println("Your new weapon is: " + this.getPlayer().getInventory().getWeapons().getName());
                }
        }
    }
    public void printArmor() {
        System.out.println("-------ARMORS-------");
        System.out.println();
        for (Armor a : Armor.armors())
            System.out.println(a.getId() + " - " + a.getName() + " Price: " + a.getCost() + " Block: " + a.getBlock());
        System.out.println("0 - Exit");
    }

    public void buyArmor()  {
        System.out.println("Select an armor");
        int selectArmorID = scan.nextInt();
        while (selectArmorID<0 || selectArmorID>Armor.armors().length)    {
            System.out.println("Re-enter your selection please!");
            selectArmorID = scan.nextInt();
        }
        if (selectArmorID != 0) {
            Armor selectedArmor = Armor.getArmorObjByID(selectArmorID);

            if (selectedArmor != null)
                if (selectedArmor.getCost() > this.getPlayer().getCoin()) System.out.println("Not enough coin.");
                else {
                    System.out.println("Purchase this armor : " + selectedArmor.getName());
                    int balance = this.getPlayer().getCoin() - selectedArmor.getCost();
                    this.getPlayer().setCoin(balance);
                    System.out.println("Your remaining coin: " + this.getPlayer().getCoin());
                    System.out.println("Your last armor is: " + this.getPlayer().getInventory().getArmor().getName());
                    this.getPlayer().getInventory().setArmor(selectedArmor);
                    System.out.println("Your new armor is: " + this.getPlayer().getInventory().getArmor().getName());
                }
        }
   }
}
