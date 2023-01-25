package xpto.model;

import lombok.Data;

import java.util.LinkedList;

@Data
public class CorporateStructureModel {

    private int vertex;
    private LinkedList[] partners;
    private double corporateProperties;

    public CorporateStructureModel(int personAmount) {
        vertex = personAmount;
        corporateProperties = 0;
        partners = new LinkedList[personAmount];
        for (int i = 0; i < vertex; ++i)
            partners[i] = new LinkedList();
    }

    public void addCorporateRelation(int person, int partner) {
        partners[person].add(partner);
    }

    public void addCorporateProperties(double propertie){
        corporateProperties += propertie;
    }

}
