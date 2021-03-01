package co.com.nxs.automotiveInventory.controllers;

import co.com.nxs.automotiveInventory.models.dtos.AppointmentDTO;
import co.com.nxs.automotiveInventory.services.AppointmentService;
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
@RequestMapping("/appointment")
@Api("This API has a CRUD for appointment")
public class AppointmentController {

    private final AppointmentService appointmentService;

    @Autowired
    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @PostMapping(path = "/save")
    @ApiOperation(value = "Insert Appointment ", response = AppointmentDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 401, message = "You are not authorized"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Internal Server Error")})
    public AppointmentDTO saveAppointment(@RequestBody AppointmentDTO appointmentDTO) {
        return appointmentService.saveAppointment(appointmentDTO);
    }

    @PutMapping(path = "/update")
    @ApiOperation(value = "Update Appointment", response = AppointmentDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 401, message = "You are not authorized"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Internal Server Error")})
    public AppointmentDTO updateAppointment(@RequestBody AppointmentDTO appointmentDTO) {
        return appointmentService.updateAppointment(appointmentDTO);
    }

    @GetMapping(path = "/all")
    @ApiOperation(value = "Find All Appointment ", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 401, message = "You are not authorized"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Internal Server Error")})
    public List<AppointmentDTO> findAllAppointment() {
        return appointmentService.findAllAppointment();
    }

    @DeleteMapping(path = "/delete")
    @ApiOperation(value = "Delete Appointment by Id", response = AppointmentDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 401, message = "You are not authorized"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Internal Server Error")})
    public String deleteAppointment(@RequestParam(name = "id") Long id) {
        return appointmentService.deleteAppointment(id);
    }
}
