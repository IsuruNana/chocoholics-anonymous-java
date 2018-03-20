abstract class User {
        public User(String n, String a, String c, String s, int z) {
                //New
                name = n;
                address = a;
                city = c;
                state = s;
                zipcode = z;
        }

        public void setName(String n) {
                name = n;
        }

        public String getName() {
                return name;
        }

        public void setAddress(String a) {
                address = a;
        }

        public String getAddress() {
                return address;
        }

        public void setCity(String c) {
                city = c;
        }

        public String getCity() {
                return city;
        }

        public void setState(String s) {
                state = s;
        }

        public String getState() {
                return state;
        }

        public void setZipcode(int z) {
                zipcode = z;
        }

        public abstract void setNumber(int n);
        public abstract int getNumber();

        private String name;
        private String address;
        private String city;
        private String state;
        private int zipcode;
        protected int number;
}


class Provider extends User {
        // Constructor
        public Provider(String n, String a, String c, String s, int z, int i) {
                super(n, a, c, s, z);
                setNumber(i);
        }

        public void setNumber(int i) {
                number = i;
        }

        public int getNumber() {
                return number;
        }

        public void initiateDirectory() {

        }

        public void initiateBillChocAn() {

        }
}

class Member extends User {
        // Constructor
        public Member(String n, String a, String c, String s, int z, int i) {
                super(n, a, c, s, z);
                setNumber(i);
        }

        public void setNumber(int i) {
                number = i;
        }

        public int getNumber() {
                return number;
        }

        public void requestHealthCare(String h) {

        }
}
 
class ProviderDirectory {
        // Need to be able to add providers to directory, keep running total,
        // and return names as strings
        // Providers already in directory???
        Provider[] providers = new Provider[100];
 
        public void getProviderList() {
                for (Provider p : providers)
                        System.out.println(p.getName());
        }
}
