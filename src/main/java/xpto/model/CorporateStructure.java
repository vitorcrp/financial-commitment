package xpto.model;

import lombok.Data;

import java.util.LinkedList;

@Data
public class CorporateStructure {

    private int vertex;
    private LinkedList<Integer> partners[];
    private int corporateProperties;

    public CorporateStructure(int personAmount) {
        vertex = personAmount;
        corporateProperties = 0;
        partners = new LinkedList[personAmount];
        for (int i = 0; i < vertex; ++i)
            partners[i] = new LinkedList();
    }

    public void addCorporateRelation(int person, int partner) {
        partners[person].add(partner);
    }

    public void addCorporateProperties(int propertie){
        corporateProperties += propertie;
    }

}
