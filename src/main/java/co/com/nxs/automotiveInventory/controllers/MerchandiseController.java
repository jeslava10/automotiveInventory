package co.com.nxs.automotiveInventory.controllers;

import co.com.nxs.automotiveInventory.models.dtos.MerchandiseDTO;
import co.com.nxs.automotiveInventory.models.dtos.MerchandiseUserDTO;
import co.com.nxs.automotiveInventory.services.MerchandiseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/merchandise")
@Api("This API has a CRUD for merchandise")
public class MerchandiseController {

    private final MerchandiseService merchandiseService;

    @Autowired
    public MerchandiseController(MerchandiseService merchandiseService) {
        this.merchandiseService = merchandiseService;
    }

    @PostMapping(path = "/save")
    @ApiOperation(value = "Insert Merchandise ", response = MerchandiseDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 401, message = "You are not authorized"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Internal Server Error")})
    public MerchandiseDTO saveMerchandise(@RequestBody MerchandiseDTO merchandiseDTO) {
        return merchandiseService.saveMerchandise(merchandiseDTO);
    }

    @PutMapping(path = "/update")
    @ApiOperation(value = "Update Merchandise", response = MerchandiseDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 401, message = "You are not authorized"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Internal Server Error")})
    public MerchandiseDTO updateMerchandise(@RequestBody MerchandiseDTO merchandiseDTO) {
        return merchandiseService.updateMerchandise(merchandiseDTO);
    }

    @GetMapping(path = "/all")
    @ApiOperation(value = "Find All Merchandise ", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 401, message = "You are not authorized"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Internal Server Error")})
    public List<MerchandiseDTO> findAllDocumentType() {
        return merchandiseService.findAllMerchandise();
    }

    @PostMapping(path = "/delete")
    @ApiOperation(value = "Delete merchandise", response = MerchandiseDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 401, message = "You are not authorized"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Internal Server Error")})
    public void deleteMerchandise(@RequestBody MerchandiseDTO merchandiseDTO) {
         merchandiseService.deleteMerchandise(merchandiseDTO);
    }

    @GetMapping(path = "/findByName")
    @ApiOperation(value = "Find ByName Merchandise ", response = MerchandiseDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 401, message = "You are not authorized"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Internal Server Error")})
    public MerchandiseDTO findByProductName(@RequestParam(name = "productName") String productName) {
        return merchandiseService.findByProductName(productName);
    }

}
