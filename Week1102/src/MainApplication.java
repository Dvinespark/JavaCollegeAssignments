
/*
 * Name: Subash Sapkota
 * StudentId: C0824340
 * 
 * */

import java.io.*;
import java.util.*;

public class MainApplication {
	
	public static String typeOfHouse;
	public static String community;
	public static String kindOfReport;
	public static void main(String[] args) {
		// inputs
		typeOfHouse = args[0];
		community = args[1];
		kindOfReport = args[2];
		Hypervisor programController = new Hypervisor();
		programController.RunProgram();
		System.out.println("--------------------------Search Parameter for Report------------------------------");
		System.out.println("HouseType: " + typeOfHouse);
		System.out.println("Community: " + community);
		System.out.println("Kind of Report: " + kindOfReport);
		
		System.out.println("--------------------------Beginning of Report------------------------------");
		System.out.format("The average selling price is %.2f\n", ReportGenerator.averageSellingPrice);
		System.out.format("The highest selling price is %.2f\n", ReportGenerator.maxSellingPrice);
		System.out.format("The lowest selling price is %.2f\n", ReportGenerator.minSellingPrice);
		System.out.println("Number of House Sold " + ReportGenerator.soldHouseCount );
		System.out.println("--------------------------End of Report------------------------------");
	}

}

class Hypervisor {
	static int lineNumber = 1;

	public void RunProgram() {
		ErrorFileLog.CreateErrorLog();
		FileHandler f = new FileHandler();
		f.importDataFile();
		ReportGenerator.showReport();
		// close error log file here: we will no longer need it. Our work here is done!
		try {
			ErrorFileLog.errorLog.flush();
			ErrorFileLog.errorLog.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		//DataStorage.OutputRecords();
	}
}

class DataStorage {
	public static ArrayList<RealEstateRecord> reRecords = new ArrayList<RealEstateRecord>();

	public static void OutputRecords() {
		// iterating ArrayList
		for (int i = 0; i < reRecords.size(); i++) {
			System.out.println(reRecords.get(i));
		}
	}
}

class ErrorFileLog {
	static String errorFileName = "C:\\Users\\longe\\Desktop\\2nd_Semester\\Java\\JavaProgrammingWorkspace\\Week1102\\Files\\errorlog.txt";

	public static BufferedWriter errorLog;

	public static void CreateErrorLog() {
		try {
			errorLog = new BufferedWriter(new FileWriter(errorFileName));
		} catch (IOException e) {
			System.out.println("CreateErrorLog  An error occurred.");
			e.printStackTrace();
		}
	}
}

class FileHandler {

	RealEstateRecord record;
	String fileName = "C:\\Users\\longe\\Desktop\\2nd_Semester\\Java\\JavaProgrammingWorkspace\\Week1102\\Files\\redata.csv";
	String line = null;

	RealEstateRecord createRealEstateRecord(String line) {
		record = new RealEstateRecord(line);
		return record;
		// System.out.println(record);
	}

	void importDataFile() {
		RealEstateRecord aRecord;
		try {
			// FileReader reads text files in the default encoding.
			FileReader fileReader = new FileReader(fileName);

			// Always wrap FileReader in BufferedReader.
			BufferedReader bufferedReader = new BufferedReader(fileReader);

			while ((line = bufferedReader.readLine()) != null) {

				// this line is RETURNING A REAL ESTATE RECORD
				// WE ARE NOT DOING ANYTHING WITH IT!
				// CREATE AN ARRAYLIST: AND STORE THESE RECORDS
				// IN AN ARRAYLIST: PROCESS IT
				aRecord = this.createRealEstateRecord(line);
				DataStorage.reRecords.add(aRecord);
			}

			// Always close files.
			bufferedReader.close();
		} catch (FileNotFoundException ex) {
			System.out.println("Unable to open file '" + fileName + "'");
		} catch (IOException ex) {
			System.out.println("Error reading file '" + fileName + "'");
		}
	}
}

class RealEstateRecord {
	BufferedWriter errorLogFile = ErrorFileLog.errorLog;
	static int numRecords = 0;
	String HouseType;
	String HouseDescription;
	String Community;
	double ListPrice;
	double SoldPrice;
	double Taxes;
	String StreetName;
	String StNumber;
	int NumberOfBedrooms;
	int NumberOfBedPlus;
	double NumberOfBaths;
	double Front;
	int ParkingDriveSpaces;
	double Depth;
	String GarageType;
	String PoolDescription;
	String BrokerRemarks;
	String RemarksForClients;
	String ExtraDetails;
	String BasementDescription1;
	String BasementDescription2;

	public RealEstateRecord(String inputLine) {
		this.parseInputLine(inputLine);
	}

	void parseInputLine(String oneLine) {
		int ArrayIndex = 0;
		String[] datafields = oneLine.split(";");
		Hypervisor.lineNumber++;
		try {
			this.errorLogFile.write("error log\r\n");

			try {
				this.HouseType = datafields[ArrayIndex];
			} catch (Exception e) {
				this.errorLogFile.write("\r\n error at line number:" + Hypervisor.lineNumber + " array Index: "
						+ ArrayIndex + "  " + datafields[ArrayIndex] + " " + this);
			}
			ArrayIndex++;
			try {
				this.HouseDescription = datafields[ArrayIndex];
			} catch (Exception e) {
				this.errorLogFile.write("\r\n error at line number:" + Hypervisor.lineNumber + " array Index: "
						+ datafields[ArrayIndex] + " " + ArrayIndex + "  " + this);

			}
			ArrayIndex++;
			try {
				this.Community = datafields[ArrayIndex];
			} catch (Exception e) {
				this.errorLogFile.write("\r\n error at line number:" + Hypervisor.lineNumber + " array Index: "
						+ datafields[ArrayIndex] + " " + ArrayIndex + "  " + this);

			}

			ArrayIndex++;
			try {
				this.ListPrice = Double.parseDouble(datafields[ArrayIndex]);
			} catch (Exception e) {
				this.errorLogFile.write("\r\n error at line number:" + Hypervisor.lineNumber + " array Index: "
						+ datafields[ArrayIndex] + " " + ArrayIndex + "  " + this);

			}

			ArrayIndex++;
			try {
				this.SoldPrice = Double.parseDouble(datafields[ArrayIndex]);
			} catch (Exception e) {
				this.errorLogFile.write("\r\n error at line number:" + Hypervisor.lineNumber + " array Index: "
						+ datafields[ArrayIndex] + " " + ArrayIndex + "  " + this);

			}

			ArrayIndex++;
			try {
				this.Taxes = Double.parseDouble(datafields[ArrayIndex]);
			} catch (Exception e) {
				this.errorLogFile.write("\r\n error at line number:" + Hypervisor.lineNumber + " array Index: "
						+ datafields[ArrayIndex] + " " + ArrayIndex + "  " + this);

			}

			ArrayIndex++;
			try {
				this.StreetName = datafields[ArrayIndex];
			} catch (Exception e) {
				this.errorLogFile.write("\r\n error at line number:" + Hypervisor.lineNumber + " array Index: "
						+ datafields[ArrayIndex] + " " + ArrayIndex + "  " + this);

			}

			ArrayIndex++;
			try {
				this.StNumber = datafields[ArrayIndex];
			} catch (Exception e) {
				this.errorLogFile.write("\r\n error at line number:" + Hypervisor.lineNumber + " array Index: "
						+ datafields[ArrayIndex] + " " + ArrayIndex + "  " + this);

			}

			ArrayIndex++;
			try {
				this.NumberOfBedrooms = Integer.parseInt(datafields[ArrayIndex]);
			} catch (Exception e) {
				this.errorLogFile.write("\r\n error at line number:" + Hypervisor.lineNumber + " array Index: "
						+ datafields[ArrayIndex] + " " + ArrayIndex + "  " + this);

			}

			ArrayIndex++;
			try {
				this.NumberOfBedPlus = Integer.parseInt(datafields[ArrayIndex]);
			} catch (Exception e) {
				this.errorLogFile.write("\r\n error at line number:" + Hypervisor.lineNumber + " array Index: "
						+ datafields[ArrayIndex] + " " + ArrayIndex + "  " + this);

			}
			ArrayIndex++;
			try {
				this.NumberOfBaths = Integer.parseInt(datafields[ArrayIndex]);
			} catch (Exception e) {
				this.errorLogFile.write("\r\n error at line number:" + Hypervisor.lineNumber + " array Index: "
						+ datafields[ArrayIndex] + " " + ArrayIndex + "  " + this);

			}
			ArrayIndex++;
			try

			{
				this.Front = Integer.parseInt(datafields[ArrayIndex]);
			} catch (Exception e) {
				this.errorLogFile.write("\r\n error at line number:" + Hypervisor.lineNumber + " array Index: "
						+ datafields[ArrayIndex] + " " + ArrayIndex + "  " + this);

			}
			ArrayIndex++;

			try {
				this.ParkingDriveSpaces = Integer.parseInt(datafields[ArrayIndex]);
			} catch (Exception e) {
				this.errorLogFile.write("\r\n error at line number:" + Hypervisor.lineNumber + " array Index: "
						+ datafields[ArrayIndex] + " " + ArrayIndex + "  " + this);

			}

			ArrayIndex++;
			try {
				this.Depth = Integer.parseInt(datafields[ArrayIndex]);
			} catch (Exception e) {
				this.errorLogFile.write("\r\n error at line number:" + Hypervisor.lineNumber + " array Index: "
						+ datafields[ArrayIndex] + " " + ArrayIndex + "  " + this);

			}

			ArrayIndex++;
			try {
				this.GarageType = datafields[ArrayIndex];
			} catch (Exception e) {
				this.errorLogFile.write("\r\n error at line number:" + Hypervisor.lineNumber + " array Index: "
						+ datafields[ArrayIndex] + " " + ArrayIndex + "  " + this);

			}
			ArrayIndex++;
			try {
				this.PoolDescription = datafields[ArrayIndex];
			} catch (Exception e) {
				this.errorLogFile.write("\r\n error at line number:" + Hypervisor.lineNumber + " array Index: "
						+ datafields[ArrayIndex] + " " + ArrayIndex + "  " + this);

			}
			ArrayIndex++;

			try {
				this.BrokerRemarks = datafields[ArrayIndex];
			} catch (Exception e) {
				this.errorLogFile.write("\r\n error at line number:" + Hypervisor.lineNumber + " array Index: "
						+ datafields[ArrayIndex] + " " + ArrayIndex + "  " + this);

			}
			ArrayIndex++;

			try {
				this.RemarksForClients = datafields[ArrayIndex];
			} catch (Exception e) {
				this.errorLogFile.write("\r\n error at line number:" + Hypervisor.lineNumber + " array Index: "
						+ datafields[ArrayIndex] + " " + ArrayIndex + "  " + this);

			}
			//ArrayIndex++;

			try {
				this.ExtraDetails = datafields[ArrayIndex];
			} catch (Exception e) {
				this.errorLogFile.write("\r\n error at line number:" + Hypervisor.lineNumber + " array Index: "
						+ datafields[ArrayIndex] + " " + ArrayIndex + "  " + this);
				// System.out.println(oneLine);
			}
			//ArrayIndex++;
			try {
				this.BasementDescription1 = datafields[ArrayIndex];
			} catch (Exception e) {
				this.errorLogFile.write("\r\n error at line number:" + Hypervisor.lineNumber + " array Index: " + " "
						+ ArrayIndex + "  " + this);
			}
			ArrayIndex++;
			try {
				this.errorLogFile.write(datafields[ArrayIndex]);
			} catch (Exception e) {
				this.errorLogFile.write("\r\n array index out of bounds : " + ArrayIndex);
			}
			// System.out.println(oneLine);

			ArrayIndex++;

			try {
				this.BasementDescription2 = datafields[ArrayIndex];
			} catch (Exception e) {
				this.errorLogFile.write("\r\n ******  error at line number:" + Hypervisor.lineNumber + " array Index: "
						+ " " + String.valueOf(ArrayIndex));
				// System.out.println(oneLine);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		numRecords++;

	}

	public String toString() {
		return this.HouseType + " " + this.HouseDescription + " " + this.StNumber + " " + this.StreetName + " "
				+ this.ListPrice + " " + this.SoldPrice;
	}
	
}

class ReportGenerator {
	private static ArrayList<RealEstateRecord> REDatabase = DataStorage.reRecords;
	private static RealEstateRecord realEstateRecord;
	// User inputs
	public static String typeOfHouse = MainApplication.typeOfHouse;
	public static String community = MainApplication.community;
	public static String kindOfReport = MainApplication.kindOfReport;
	public static double averageSellingPrice;
	public static double totalSoldPriceSum = 0;
	public static int soldHouseCount = 0;
	public static double minSellingPrice = 0;
	public static double maxSellingPrice = 0;
	
	public static void showReport() {
		// algorithm
		// step 1 walk over the array list
//		for (RealEstateRecord realEstateRecord: REDatabase) {
//			if (realEstateRecord.HouseType.equals("Detached")) {
//				System.out.println(realEstateRecord);
//			}
//		}
		int counter = 0;
		for (int i=0; i< REDatabase.size(); i++) {
			realEstateRecord = REDatabase.get(i);
			
			// get the counter value to calculate minimum value as we need to compare two values
			if (realEstateRecord.HouseType.equals(typeOfHouse) && realEstateRecord.Community.equals(community) && counter == 0) {
				minSellingPrice = realEstateRecord.SoldPrice;
				counter = i;
			}
			if (realEstateRecord.HouseType.equals(typeOfHouse) && realEstateRecord.Community.equals(community)) {
				
				// calculating no of house sold count and summation of sold price
				soldHouseCount++;
				totalSoldPriceSum+=realEstateRecord.SoldPrice;			
				
				// calculating for maximum and minimum sold price
				if (maxSellingPrice < realEstateRecord.SoldPrice) {
					maxSellingPrice = realEstateRecord.SoldPrice;
				}
				if (i > counter && minSellingPrice > realEstateRecord.SoldPrice) {
					minSellingPrice = realEstateRecord.SoldPrice;
					counter = i;
				}
				
			}
		}
		// calculating average value
		averageSellingPrice = totalSoldPriceSum / soldHouseCount;
	}
}