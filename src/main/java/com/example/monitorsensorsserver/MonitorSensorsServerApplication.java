package com.example.monitorsensorsserver;

import com.example.monitorsensorsserver.entity.Role;
import com.example.monitorsensorsserver.entity.Type;
import com.example.monitorsensorsserver.entity.Unit;
import com.example.monitorsensorsserver.entity.Usr;
import com.example.monitorsensorsserver.service.RoleService;
import com.example.monitorsensorsserver.service.TypeService;
import com.example.monitorsensorsserver.service.UnitService;
import com.example.monitorsensorsserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MonitorSensorsServerApplication implements CommandLineRunner {

    private final TypeService typeService;
    private final UnitService unitService;
    private final UserService userService;
    private final RoleService roleService;

    @Autowired
    public MonitorSensorsServerApplication(TypeService typeService, UnitService unitService, UserService userService, RoleService roleService) {

        this.typeService = typeService;
        this.unitService = unitService;
        this.userService = userService;
        this.roleService = roleService;
    }

    public static void main(String[] args) {

        SpringApplication.run(MonitorSensorsServerApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

//        Type pressure = new Type();
//        pressure.setTypeName(Type.TypeName.PRESSURE);
//        typeService.save(pressure);
//        Type voltage = new Type();
//        voltage.setTypeName(Type.TypeName.VOLTAGE);
//        typeService.save(voltage);
//        Type temperature = new Type();
//        temperature.setTypeName(Type.TypeName.TEMPERATURE);
//        typeService.save(temperature);
//        Type humidity = new Type();
//        humidity.setTypeName(Type.TypeName.HUMIDITY);
//        typeService.save(humidity);
//
//        Unit bar = new Unit();
//        bar.setUnitName(Unit.UnitName.BAR);
//        unitService.save(bar);
//        Unit voltageUnit = new Unit();
//        voltageUnit.setUnitName(Unit.UnitName.VOLTAGE);
//        unitService.save(voltageUnit);
//        Unit celsius = new Unit();
//        celsius.setUnitName(Unit.UnitName.CELSIUS);
//        unitService.save(celsius);
//        Unit percent = new Unit();
//        percent.setUnitName(Unit.UnitName.PERCENT);
//        unitService.save(percent);
//
//        Role viewer = new Role();
//        viewer.setRoleName(Role.RoleName.VIEWER);
//        roleService.save(viewer);
//
//        Role adminRole = new Role();
//        adminRole.setRoleName(Role.RoleName.ADMIN);
//        roleService.save(adminRole);
//
//        Usr user = new Usr();
//        user.setLogin("user");
//        user.setPassword("1234");
//        user.setRole(viewer);
//        userService.save(user);
//
//        Usr admin = new Usr();
//        admin.setLogin("admin");
//        admin.setPassword("1234");
//        admin.setRole(adminRole);
//        userService.save(admin);
    }
}
