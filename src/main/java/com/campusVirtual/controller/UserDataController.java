package com.campusVirtual.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.campusVirtual.dto.UserRegisterDto;
import com.campusVirtual.service.IUserDataService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;

@RestController
@RequestMapping("v1/userdata/")
public class UserDataController {

  @Autowired
  private IUserDataService userService;


  @Operation(summary = "Get User Data by Context")
  @ApiResponses(value = {
          @ApiResponse(responseCode = "200", description = "Get User",
                  content = { @Content(mediaType = "application/json",
                          schema = @Schema(implementation = UserRegisterDto.class)) }),
})
  @GetMapping(path="")
  public  ResponseEntity<UserRegisterDto> getUserDataDtoByContext(){
    return  ResponseEntity.ok()
    .body(this.userService.getUserDataDtoByContext());
  }


}
