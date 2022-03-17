package co.ke.emtechhouse.RAOServer.services;

import co.ke.emtechhouse.RAOServer.exceptions.DataNotFoundException;
import co.ke.emtechhouse.RAOServer.models.Kycdata;
import co.ke.emtechhouse.RAOServer.repositories.KycdataRepo;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class KycdataService {
    private final KycdataRepo kycdataRepo;

    public KycdataService(KycdataRepo kycdataRepo) {
        this.kycdataRepo = kycdataRepo;
    }

    public Kycdata addKycdata(Kycdata kycdata){
        try {
            return kycdataRepo.save(kycdata);
        }catch (Exception e) {
            return null;
        }
    }
    public List<Kycdata> findAllKycdatas(){
        try {
            return kycdataRepo.findAll();
        }catch (Exception e) {
            return null;
        }
    }
    public Kycdata findKycdataById(Long id){
        try {
            return kycdataRepo.findById(id).orElseThrow(()-> new DataNotFoundException("Kyc Data with id:  " + id +" was not found"));
        }catch (Exception e) {
            return null;
        }
    }
//    public List<Kycdata> findKycdataByUserId(String user_id){
//        try {
//            return kycdataRepo.findByUserId(user_id);
//        }catch (Exception e) {
//            return null;
//        }
//    }
    public Kycdata updateKycdata(Kycdata kycdata){
        try {
            return kycdataRepo.save(kycdata);
        }catch (Exception e) {
            return null;
        }
    }
    public void deleteKycdata(Long id){
        try {
            kycdataRepo.deleteById(id);
        }catch (Exception e) {
        }
    }
}
