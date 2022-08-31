package Controller;

import Repository.InformationRepository;

public class InformationController {
    private InformationRepository informationRepository;

    public InformationController(){
        this.informationRepository = new InformationRepository();
    }

    public boolean add(String text) {
        return informationRepository.add(text);
    }

    public String printInformation() {
        return informationRepository.printInformation();
    }




}
