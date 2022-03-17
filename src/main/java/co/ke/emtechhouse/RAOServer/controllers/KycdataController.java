package co.ke.emtechhouse.RAOServer.controllers;

import co.ke.emtechhouse.RAOServer.models.Kycdata;
import co.ke.emtechhouse.RAOServer.services.KycdataService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@Slf4j
@Api(value = "/KYC Data API", tags = "Kyc Data")
@RequestMapping("/api/v1/kycdata/")
public class KycdataController {

    private final KycdataService kycdataService;

    public KycdataController(KycdataService kycdataService) {
        this.kycdataService = kycdataService;
    }

    @PostMapping("/add")
    public ResponseEntity<?> addKycdata(@RequestBody Kycdata kycdata){
        Kycdata newKycdata = kycdataService.addKycdata(kycdata);
        return  new ResponseEntity<>(newKycdata, HttpStatus.CREATED);
    }
    @GetMapping("/all")
    public ResponseEntity<List<Kycdata>> getAllKycdatas () {
        List<Kycdata> kycdatas = kycdataService.findAllKycdatas();
        return  new ResponseEntity<>(kycdatas, HttpStatus.OK);
    }
    @GetMapping("/find/{id}")
    public ResponseEntity<Kycdata> getKycdataById (@PathVariable("id") Long id){
        Kycdata kycdata = kycdataService.findKycdataById(id);
        return new ResponseEntity<>(kycdata, HttpStatus.OK);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Kycdata> updateKycdata(@PathVariable("id") long id, @RequestBody Kycdata kycdata){
        Kycdata newKycdata = kycdataService.updateKycdata(kycdata);
        return  new ResponseEntity<>(newKycdata, HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Kycdata> deleteKycdata(@PathVariable("id") Long id){
        kycdataService.deleteKycdata(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}