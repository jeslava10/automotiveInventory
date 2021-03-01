package co.com.nxs.automotiveInventory.controllers;

import co.com.nxs.automotiveInventory.models.dtos.MerchandiseUserDTO;
import co.com.nxs.automotiveInventory.services.MerchandiseUserService;
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
@RequestMapping("/user")
@Api("This API has a CRUD for User")
public class MerchandiseUserController {

    private final MerchandiseUserService merchandiseUserService;

    @Autowired
    public MerchandiseUserController(MerchandiseUserService merchandiseUserService) {
        this.merchandiseUserService = merchandiseUserService;
    }

    @PostMapping(path = "/save")
    @ApiOperation(value = "Insert User ", response = MerchandiseUserDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 401, message = "You are not authorized"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Internal Server Error")})
    public MerchandiseUserDTO saveMerchandiseUser(@RequestBody MerchandiseUserDTO merchandiseUserDTO) {
        return merchandiseUserService.saveMerchandiseUser(merchandiseUserDTO);
    }

    @PutMapping(path = "/update")
    @ApiOperation(value = "Update User", response = MerchandiseUserDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 401, message = "You are not authorized"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Internal Server Error")})
    public MerchandiseUserDTO updateMerchandiseUser(@RequestBody MerchandiseUserDTO merchandiseUserDTO) {
        return merchandiseUserService.updateMerchandiseUser(merchandiseUserDTO);
    }

    @GetMapping(path = "/all")
    @ApiOperation(value = "Find All User ", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 401, message = "You are not authorized"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Internal Server Error")})
    public List<MerchandiseUserDTO> findAllDocumentType() {
        return merchandiseUserService.findAllMerchandiseUser();
    }

    @DeleteMapping(path = "/delete")
    @ApiOperation(value = "Delete User by Id", response = MerchandiseUserDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 401, message = "You are not authorized"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Internal Server Error")})
    public String deleteMerchandise(@RequestParam(name = "id") Long id) {
        return merchandiseUserService.deleteMerchandiseUser(id);
    }
}
