import java.util.Scanner;

    // Base class for branches
    class Branch {
        protected String branchName;
        protected int tuitionFees;
        protected int cautionDeposit;

        public Branch(String branchName, int tuitionFees, int cautionDeposit) {
            this.branchName = branchName;
            this.tuitionFees = tuitionFees;
            this.cautionDeposit = cautionDeposit;
        }

        public String getBranchName() {
            return branchName;
        }

        public int getTuitionFees() {
            return tuitionFees;
        }

        public int getCautionDeposit() {
            return cautionDeposit;
        }
    }

    // Campus class representing different campuses
    class Campus {
        protected String campusName;
        protected Branch[] branches;

        public Campus(String campusName, Branch[] branches) {
            this.campusName = campusName;
            this.branches = branches;
        }

        public String getCampusName() {
            return campusName;
        }

        public Branch[] getBranches() {
            return branches;
        }
    }

    // VITCounselling class representing the counseling process
    class VITCounselling {
        private Campus[] campuses;
        int phaseOffset = 0;

        public VITCounselling(Campus[] campuses) {
            this.campuses = campuses;
        }

        public void performCounselling(int rank) {
            String phase;

            if (rank >= 1 && rank <= 20000) {
                phase = "PHASE 1";
            } else if (rank >= 20001 && rank <= 45000) {
                phase = "PHASE 2";
                phaseOffset++;
            } else if (rank >= 45001 && rank <= 70000) {
                phase = "PHASE 3";
                phaseOffset++;
            } else if (rank >= 70001 && rank <= 100000) {
                phase = "PHASE 4";
                phaseOffset++;
            } else {
                System.out.println("Invalid rank!");
                return;
            }

            System.out.println("Counseling Phase: " + phase);
            System.out.println("--------------------------");

            for (Campus campus : campuses) {
                System.out.println("Campus: " + campus.getCampusName());
                System.out.println("Branches available:");

                for (int i = 0; i < campus.getBranches().length; i++) {
                    Branch currentBranch = campus.getBranches()[i];
                    int increasedTuitionFees = currentBranch.getTuitionFees() + (phaseOffset * 100000);

                    System.out.println((i + 1) + ". Branch: " + currentBranch.getBranchName());
                    System.out.println(" Tuition Fees: INR " + increasedTuitionFees);
                    System.out.println(" Caution Deposit: INR " + currentBranch.getCautionDeposit());
                    System.out.println();
                }

                System.out.println("--------------------------");
            }
        }
    }

    public class m {
        public static void main(String[] args) {
            // Create branch objects
            Branch[] branches = {
                    new Branch("Bioengineering", 173000, 3000),
                    new Branch("Biotechnology", 173000, 3000),
                    new Branch("Chemical Engineering", 173000, 3000),
                    new Branch("Civil Engineering", 173000, 3000),
                    new Branch("Electrical and Electronics Engineering", 173000, 3000),
                    new Branch("Electronics and Instrumentation Engineering", 173000, 3000),
                    new Branch("Fashion Technology", 173000, 3000),
                    new Branch("Aerospace Engineering", 195000, 3000),
                    new Branch("Computer Science and Engineering (Internet of Things)", 195000, 3000),
                    new Branch("Computer Science and Engineering with Business systems", 195000, 3000),
                    new Branch("Electronics and Communication Engineering (Biomedical Engineering)", 195000, 3000),
                    new Branch("Computer Science and Engineering (Bioinformatics)", 195000, 3000),
                    new Branch("Electronics and Communication Engineering", 195000, 3000),
                    new Branch("Computer Science and Engineering Core", 195000, 3000),
                    new Branch("Electrical and Communication Core", 195000, 3000),
                    new Branch("Computer Science and Engineering with specialisation in Networking and Security", 195000, 3000),
                    new Branch("Mechanical Engineering (Specialisation in Artificial Intelligence and Robotics)", 195000, 3000),
                    new Branch("Electronics and Computer Engineering", 195000, 3000),
                    new Branch("Electrical and Computer Science Engineering", 195000, 3000)
            };

            // Create campus objects
            Campus[] campuses = {
                    new Campus("VIT Vellore", branches),
                    new Campus("VIT Chennai", branches),
                    new Campus("VIT Bhopal", branches),
                    new Campus("VIT Amravati", branches)
            };

            // Create VITCounselling object
            VITCounselling counselling = new VITCounselling(campuses);

            // Perform counselling based on rank
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter your rank: ");
            int rank = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character
            counselling.performCounselling(rank);

            System.out.print("Choose an option (Campus/Branch number): ");
            String option = scanner.nextLine();

            // Parse the user's option
            String[] parts = option.split("/");

            if (parts.length != 2) {
                System.out.println("Invalid option!");
                return;
            }

            int campusNumber = Integer.parseInt(parts[0]) - 1;
            int branchNumber = Integer.parseInt(parts[1]) - 1;

            if (campusNumber < 0 || campusNumber >= campuses.length || branchNumber < 0 ||
                    branchNumber >= campuses[campusNumber].getBranches().length) {
                System.out.println("Invalid option!");
                return;
            }

            Campus selectedCampus = campuses[campusNumber];
            Branch selectedBranch = selectedCampus.getBranches()[branchNumber];
            int increasedTuitionFees = selectedBranch.getTuitionFees() + (counselling.phaseOffset * 100000);

            System.out.println("Congratulations! You have been admitted to:");
            System.out.println("Campus: " + selectedCampus.getCampusName());
            System.out.println("Branch: " + selectedBranch.getBranchName());
            System.out.println("Tuition Fees: INR " + increasedTuitionFees);
            System.out.println("Caution Deposit: INR " + selectedBranch.getCautionDeposit());


        }
    }


