//package FamilyTree;
//
//import java.util.*;
//
//public class Main {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        String searchedPerson = scanner.nextLine();
//        String input = scanner.nextLine();
//        List<Parent> parentsByName = new ArrayList<>();
//
//        List<Child> childrenByName = new ArrayList<>();
//       while (!input.equals("End")) {
//            String nameParent = "";
//            String nameChild = "";
//            if (input.contains("-")) {
//                String[] partitions = input.split("-");
//                if (!partitions[0].contains("/") && !partitions[1].contains("/")) {
//                    String firstNameParent = partitions[0].split("\\s+")[0];
//                    String secondNameParent = partitions[0].split("\\s+")[1];
//                    String firstNameChild = partitions[1].split("\\s+")[0];
//                    String lastNameChild = partitions[1].split("\\s+")[1];
//                    Parent parent = new Parent(firstNameParent, secondNameParent);
//                    Child child = new Child(firstNameChild, lastNameChild);
//                    boolean isFound = false;
//                    for (Parent parent1 : parentsByName) {
//                        if (parent1.getFirstName().equals(firstNameParent) && parent1.getLastName().equals(secondNameParent)) {
//                            if (parent1.getChildren().size() == 0) {
//                                parent1.getChildren().add(child);
//                                child.getParents().add(parent);
//                                childrenByName.add(child);
//
//                            } else {
//                                for (Child parentChild : parent1.getChildren()) {
//                                    if (!parentChild.getParents().contains(parent)) {
//                                        parentChild.getParents().add(parent);
//                                    }
//                                }
//
//                                if(!parent1.getChildren().contains(child)){
//                                    parent1.getChildren().add(child);
//                                }
//                            }
//                            isFound = true;
//                            break;
//                        }
//
//                    }
//                    if (isFound == false) {
//
//                        parentsByName.add(parent);
//                        parent.getChildren().add(child);
//                        child.getParents().add(parent);
//                        childrenByName.add(child);
//
//
//                    }
//
//
//                } else if (!partitions[0].contains("/") && partitions[1].contains("/")) {
//                    String firstNameParent = partitions[0].split("\\s+")[0];
//                    String secondNameParent = partitions[0].split("\\s+")[1];
//                    String birthdayChild = partitions[1];
//                    Parent parent = new Parent(firstNameParent, secondNameParent);
//                    Child child = new Child(birthdayChild);
//
//                    boolean isFound = false;
//                    for (Parent parent1 : parentsByName) {
//                        if (parent1.getFirstName().equals(firstNameParent) && parent1.getLastName().equals(secondNameParent)) {
//                            if (parent1.getChildren().size() == 0) {
//                                parent1.getChildren().add(child);
//                                child.getParents().add(parent);
//                                childrenByName.add(child);
//
//                            } else {
//                                for (Child parentChild : parent1.getChildren()) {
//                                    if (!parentChild.getParents().contains(parent)) {
//                                        parentChild.getParents().add(parent);
//                                    }
//                                }
//                                if(!parent1.getChildren().contains(child)){
//                                    parent1.getChildren().add(child);
//                                }else{
//                                    parent1.getChildren().get()
//                                }
//
//                            }
//                            isFound = true;
//                            break;
//                        }
//
//                    }
//                    if (isFound == false) {
//
//                        parentsByName.add(parent);
//                        parent.getChildren().add(child);
//                        child.getParents().add(parent);
//                        childrenByName.add(child);
//
//
//                    }
//
//
//                } else if (partitions[0].contains("/") && !partitions[1].contains("/")) {
//                    String birthdayParent = partitions[0];
//                    String firstNameChild = partitions[1].split("\\s+")[0];
//                    String lastNameChild = partitions[1].split("\\s+")[1];
//                    for (Parent parent : parentsByName) {
//                        if (parent.getBirthday().equals(birthdayParent)) {
//                            for (Child child : parent.getChildren()) {
//                                if (!child.getFirstName().equals(firstNameChild) && child.getLastName().equals(lastNameChild)) {
//                                    Child child1 = new Child(firstNameChild, lastNameChild);
//                                    parent.getChildren().add(child1);
//                                    childrenByName.add(child1);
//                                }
//                            }
//
//                        } else {
//                            Parent parent1 = new Parent(birthdayParent);
//                            Child child1 = new Child(firstNameChild, lastNameChild);
//                            parentsByName.add(parent1);
//                            childrenByName.add(child1);
//                            parent1.getChildren().add(child1);
//                            child1.getParents().add(parent1);
//
//                        }
//                    }
//
//                } else if (partitions[0].contains("/") && partitions[1].contains("/")) {
//                    String birthdayParent = partitions[0];
//                    String birthdayChild = partitions[1];
//                    for (Parent parent : parentsByName) {
//                        if (parent.getBirthday().equals(birthdayParent)) {
//                            for (Child child : parent.getChildren()) {
//                                if (!child.getBirthday().equals(birthdayChild)) {
//                                    Child child1 = new Child(birthdayChild);
//                                    parent.getChildren().add(child1);
//                                    childrenByName.add(child1);
//                                }
//                            }
//
//                        } else {
//                            Parent parent1 = new Parent(birthdayParent);
//                            Child child1 = new Child(birthdayChild);
//                            parentsByName.add(parent1);
//                            childrenByName.add(child1);
//                            parent1.getChildren().add(child1);
//                            child1.getParents().add(parent1);
//
//                        }
//                    }
//
//                }
//            } else {
//                String firstNameParent = input.split("\\s+")[0];
//                String secondNameParent = input.split("\\s+")[1];
//                String birthdayParent = input.split("\\s+")[2];
//                for (Parent parent : parentsByName) {
//                    if (parent.getFirstName().equals(firstNameParent) && parent.getLastName().equals(secondNameParent)) {
//                        parent.setBirthday(birthdayParent);
//                    } else {
//                        Parent parent1 = new Parent(firstNameParent, secondNameParent, birthdayParent);
//                        parentsByName.add(parent1);
//                    }
//                }
//
//
//            }
//
//
//            input = scanner.nextLine();
//        }
//
//
//    }
//
//}
