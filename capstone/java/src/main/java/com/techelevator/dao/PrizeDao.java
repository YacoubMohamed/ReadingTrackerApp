package com.techelevator.dao;

import com.techelevator.model.Prize;

import java.util.List;

public interface PrizeDao {

    void deletePrize (int prizeId);
    void updatePrize (Prize prize);
    List<Prize> getAllPrizesByFamilyId(int familyId);
    Prize getPrizesById (int prizesId);
    List<Prize> getAllPrizesByUserId(int userId);
  //  void addPrizeToUser(Prize newPrize);
    void addPrizeToFamily(Prize newPrize);

}
