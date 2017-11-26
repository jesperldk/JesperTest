package jesperl.dk.smoothieaq.shared.model.Task;

import static jesperl.dk.smoothieaq.shared.model.device.DeviceClass.*;
import static jesperl.dk.smoothieaq.shared.model.device.DeviceType.*;
import static jesperl.dk.smoothieaq.shared.model.measure.MeasurementType.*;

import jesperl.dk.smoothieaq.shared.model.device.*;

public enum TaskType {
	
	auto(100,no,null),
	autoDevice(110,no,auto),
	autoMeasure(120,DeviceClass.sensor,false,false,autoDevice),
	autoOnoff(130,DeviceClass.onoff,true,true,autoDevice),
	autoStatus(131,DeviceClass.status,true,true,autoDevice),
	autoLevel(140,level,true,false,autoDevice,LevelTaskArg.create(7)),
	autoLevelStream(141,level,true,true,autoDevice),
	autoProgram(142,level,true,false,autoDevice,ProgramTaskArg.create(20)),
	autoDoseAmount(150,DeviceClass.doser,false,false,autoDevice,LevelTaskArg.create(7)),
	autoDoseMax(151,DeviceClass.doser,true,true,autoDevice,LevelTaskArg.create(7)),
	
	manual(200,no,null),
	
	other(300,manual,DescriptionTaskArg.create()),

	manualDosing(400,no,manual),
	dosing(410,manualDosing,ValueTaskArg.create(volume,0,null,null)),
	dryDosing(420,manualDosing,ValueTaskArg.create(weight,0,null,null)),

	manualMeassure(500,manual,MeasurementTaskArg.create()),

	maintenanceDevice(600,manual),
	calibrate(610,maintenanceDevice),
	checkAndRefill(620,DeviceClass.container,maintenanceDevice),
	
	clean(630,maintenanceDevice),
	cleanPrefilter(631,filter,clean),
	cleanMainfilter(632,filter,clean),
	cleanTubes(633,filter,clean),

	maintenanceTank(640,manual),
	changeWater(641,tank,maintenanceTank,ValueTaskArg.create(change,0,null,ValueTaskArg.water)),
	topUpWater(642,tank,maintenanceTank,ValueTaskArg.create(volume,0,null,ValueTaskArg.water)),
	cleanPanels(643,tank,maintenanceTank),
	;
	
	private int id;
	private DeviceClass deviceClass;
	private DeviceType deviceType;
	private boolean intervalSchedule;
	private boolean whenAllowed;
	private TaskType parrentType;
	private TaskArg taskArg;
	
	private TaskType(int id, TaskType parrentType) { this(id,DeviceClass.manual,false,false,parrentType,null); }
	private TaskType(int id, TaskType parrentType, TaskArg taskArg) { this(id,DeviceClass.manual,false,false,parrentType,taskArg); }
	private TaskType(int id, DeviceType deviceType, TaskType parrentType) { this(id,DeviceClass.manual,deviceType,false,false,parrentType,null); }
	private TaskType(int id, DeviceType deviceType, TaskType parrentType, TaskArg taskArg) { this(id,DeviceClass.manual,deviceType,false,false,parrentType,taskArg); }
	private TaskType(int id, DeviceClass deviceClass, TaskType parrentType) { this(id,deviceClass,false,false,parrentType,null); }
	private TaskType(int id, DeviceClass deviceClass, boolean intervalSchedule, boolean whenAllowed, TaskType parrentType) { this(id,deviceClass,intervalSchedule,whenAllowed,parrentType,null); }
	private TaskType(int id, DeviceClass deviceClass, boolean intervalSchedule, boolean whenAllowed, TaskType parrentType, TaskArg taskArg) { this(id, deviceClass, defaultType(deviceClass), intervalSchedule,whenAllowed, parrentType, taskArg); }
	private TaskType(int id, DeviceClass deviceClass, DeviceType deviceType, boolean intervalSchedule, boolean whenAllowed, TaskType parrentType, TaskArg taskArg) {
		this.id = id;
		this.deviceClass = deviceClass;
		this.deviceType = deviceType;
		this.intervalSchedule = intervalSchedule;
		this.whenAllowed = whenAllowed;
		this.parrentType = parrentType;
		this.taskArg = taskArg;
	}
	private static DeviceType defaultType(DeviceClass deviceClass) {
		if (deviceClass == DeviceClass.sensor) return DeviceType.sensor;
		if (deviceClass == DeviceClass.doser) return DeviceType.doser;
		if (deviceClass == DeviceClass.status) return DeviceType.status;
		return null;
	}
	
	public DeviceClass getDeviceClass() { return deviceClass; }
	public DeviceType getDeviceType() { return deviceType; }
	public boolean isIntervalSchedule() { return intervalSchedule; }
	public boolean isWhenAllowed() { return whenAllowed; }
	public TaskType getParrentType() { return parrentType; }
	public boolean isOfType(TaskType type) { return this.equals(type) || (parrentType != null && parrentType.equals(type)); }
	public TaskArg getTaskArg() { return taskArg; }
	public int getId() { return id; }
}
