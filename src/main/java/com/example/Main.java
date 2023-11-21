package com.example;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Main {
    private static final XmlMapper DEFAULT_MAPPER = new XmlMapper();

    public static void main(String[] args) {
        final String fileObjects = "C:\\Users\\grand\\Downloads\\Тест ЦНИИТЭИ-ИС\\Тест ЦНИИТЭИ-ИС\\AS_ADDR_OBJ.XML";
        final String fileHierarchy = "C:\\Users\\grand\\Downloads\\Тест ЦНИИТЭИ-ИС\\Тест ЦНИИТЭИ-ИС\\AS_ADM_HIERARCHY.XML";

        task1(fileObjects);
        task2(fileObjects, fileHierarchy);
    }

    /*
      Задача № 1
      По переданному набору идентификаторов OBJECTID, вывести описание адресов
      (тип + название) на переданную дату.
      Путь к файлам можно передать либо также параметром, либо «зашить» в коде приложения.
      */
    public static void task1(String file) {

        //чтение файла
        try {
            final File xmlFile = new File(file);
            XmlMapper mapper = DEFAULT_MAPPER;
            mapper.registerModule(new JavaTimeModule());
            List<Address> list = mapper.readValue(xmlFile, new TypeReference<List<Address>>() {
            });

            //прочитать дату
            Scanner in = new Scanner(System.in);
            String dateString = in.nextLine();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

            LocalDate date = LocalDate.parse(dateString, formatter);

            //прочитать строку со списком ObjectId
            String objectsIdString = in.nextLine();
            String[] objectsIdArray = objectsIdString.split(", ");

            //обход файла, с отбором по ObjectId и дате
            //вывод в консоль
            for (Address address :
                    list) {
                if (objectsIdArrayContainsObjectId(objectsIdArray, address.getObjectId())
                        && address.getStartDate().isBefore(date)
                        && address.getEndDate().isAfter(date)) {
                    System.out.println(address.getObjectId() + ": " + address.getTypeName() + " " + address.getName());
                }
            }
        } catch (Exception e) {
            //обработать ошибку
            System.out.println(e.getMessage());
        }
    }

    public static boolean objectsIdArrayContainsObjectId(String[] objectsIdArray, String findObjectId) {
        return Arrays.stream(objectsIdArray).anyMatch(findObjectId::equals);
    }

    /*
    Вывести актуальные полные адреса (строку с цепочкой адресов по иерархии), в которых встречается тип
    адреса = «проезд».
     */
    public static void task2(String fileObjects, String fileHierarchy) {

        //чтение файлов
        try {
            final File xmlFile = new File(fileObjects);
            XmlMapper mapper = DEFAULT_MAPPER;
            List<Address> listAddresses = mapper.readValue(xmlFile, new TypeReference<List<Address>>() {
            });

            final File xmlFileHierarchies = new File(fileHierarchy);
            List<Hierarchy> listHierarchies = mapper.readValue(xmlFileHierarchies, new TypeReference<List<Hierarchy>>() {
            });

            //поиск проезда в адресах
            for (Address address :
                    listAddresses) {
                if (address.getTypeName().contains("проезд")
                        && (address.getIsActive() || address.getIsActive())) {
                    ArrayList<String> arrayParents = new ArrayList<>();

                    //заполнить массив id родителей
                    findParents(address.getObjectId(), listHierarchies, arrayParents);

                    //обход массива родителей с конца
                    StringBuilder stringBuilder = new StringBuilder();

                    for (int i = arrayParents.size() - 1; i >= 0; i--) {
                        String objectId = arrayParents.get(i);
                        Optional<Address> parent = listAddresses.stream().filter(c -> c.getObjectId().contains(objectId) && (c.getIsActive() || c.getIsActual())).findFirst();
                        if (!parent.isEmpty()) {
                            stringBuilder.append(parent.get().getTypeName() + " " + parent.get().getName() + " ");
                        }

                    }
                    stringBuilder.append(address.getTypeName() + " " + address.getName());
                    System.out.println(stringBuilder.toString());
                }

            }
        } catch (Exception e) {
            //обработать ошибку
            System.out.println(e.getMessage());
        }


    }

    //обход иерархии чтобы заполнить массив с id родителей
    public static void findParents(String objectId, List<Hierarchy> listHierarchies, ArrayList<String> arrayObjectId) {
        String finalObjectId = objectId;
        Optional<Hierarchy> parent = listHierarchies.stream().filter(c -> c.getObjectId().contains(finalObjectId) && c.isActive() && !c.getParentObjId().equals("0")).findFirst();
        if (!parent.isEmpty()) {
            objectId = parent.get().getParentObjId();
            arrayObjectId.add(objectId);
            findParents(objectId, listHierarchies, arrayObjectId);
        }
    }
}




