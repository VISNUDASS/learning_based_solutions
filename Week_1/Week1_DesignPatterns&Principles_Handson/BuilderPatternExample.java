public class BuilderPatternExample {

    public static class Computer {
        private String CPU;
        private String RAM;
        private String storage;
        private String graphicsCard;
        private String keyboard;
        private String monitor;
        private Computer(Builder builder) {
            this.CPU = builder.CPU;
            this.RAM = builder.RAM;
            this.storage = builder.storage;
            this.graphicsCard = builder.graphicsCard;
            this.keyboard = builder.keyboard;
            this.monitor = builder.monitor;
        }
        public void showSpecs() {
            System.out.println("Computer Configuration:");
            System.out.println("CPU: " + CPU);
            System.out.println("RAM: " + RAM);
            System.out.println("Storage: " + storage);
            System.out.println("Graphics Card: " + graphicsCard);
            System.out.println("Keyboard: " + keyboard);
            System.out.println("Monitor: " + monitor);
            System.out.println("--------------------------------");
        }
        public static class Builder {
            private String CPU;
            private String RAM;
            private String storage;
            private String graphicsCard;
            private String keyboard;
            private String monitor;

            public Builder setCPU(String CPU) {
                this.CPU = CPU;
                return this;
            }

            public Builder setRAM(String RAM) {
                this.RAM = RAM;
                return this;
            }

            public Builder setStorage(String storage) {
                this.storage = storage;
                return this;
            }

            public Builder setGraphicsCard(String graphicsCard) {
                this.graphicsCard = graphicsCard;
                return this;
            }

            public Builder setKeyboard(String keyboard) {
                this.keyboard = keyboard;
                return this;
            }

            public Builder setMonitor(String monitor) {
                this.monitor = monitor;
                return this;
            }

            public Computer build() {
                return new Computer(this);
            }
        }
    }

    public static void main(String[] args) {

        // Basic Computer
        Computer basicComputer = new Computer.Builder()
                .setCPU("Intel i3")
                .setRAM("4GB")
                .setStorage("256GB SSD")
                .build();

        Computer gamingComputer = new Computer.Builder()
                .setCPU("Intel i9")
                .setRAM("32GB")
                .setStorage("2TB SSD")
                .setGraphicsCard("NVIDIA RTX 4090")
                .setKeyboard("Mechanical RGB")
                .setMonitor("4K Ultra HD")
                .build();

        Computer officeComputer = new Computer.Builder()
                .setCPU("AMD Ryzen 5")
                .setRAM("16GB")
                .setStorage("1TB HDD")
                .setMonitor("1080p Display")
                .build();

        basicComputer.showSpecs();
        gamingComputer.showSpecs();
        officeComputer.showSpecs();
    }
}
