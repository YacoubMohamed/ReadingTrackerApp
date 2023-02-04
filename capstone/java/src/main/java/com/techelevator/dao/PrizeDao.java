package com.techelevator.dao;

import com.techelevator.model.Prize;

import java.util.List;

public interface PrizeDao {

    void deletePrize (int prizeId);
    void updatePrize (Prize prize);
    List<Prize> getAllPrizes (int familyId);
    Prize getPrizesById (int prizesId);
    Prize getPrizesByFamilyId (int familyId);
    Prize getPrizesByUserId (int userId);
    void addPrizeToUser();
    void addPrizeToFamily();

}
