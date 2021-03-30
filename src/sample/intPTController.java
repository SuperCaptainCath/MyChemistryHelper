package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class intPTController {

    //Fields in the information box about the element
    @FXML private Text elementSymbolText;
    @FXML private Text elementNameText;
    @FXML private Text elementAtomicNumText;
    @FXML private Text elementAtomicMassText;
    @FXML private Text elementMeltPtText;
    @FXML private Text elementBoilPtText;

    //ToggleButtons of each element
    @FXML private ToggleButton b1;
    @FXML private ToggleButton b2;
    @FXML private ToggleButton b3;
    @FXML private ToggleButton b4;
    @FXML private ToggleButton b5;
    @FXML private ToggleButton b6;
    @FXML private ToggleButton b7;
    @FXML private ToggleButton b8;
    @FXML private ToggleButton b9;
    @FXML private ToggleButton b10;
    @FXML private ToggleButton b11;
    @FXML private ToggleButton b12;
    @FXML private ToggleButton b13;
    @FXML private ToggleButton b14;
    @FXML private ToggleButton b15;
    @FXML private ToggleButton b16;
    @FXML private ToggleButton b17;
    @FXML private ToggleButton b18;
    @FXML private ToggleButton b19;
    @FXML private ToggleButton b20;
    @FXML private ToggleButton b21;
    @FXML private ToggleButton b22;
    @FXML private ToggleButton b23;
    @FXML private ToggleButton b24;
    @FXML private ToggleButton b25;
    @FXML private ToggleButton b26;
    @FXML private ToggleButton b27;
    @FXML private ToggleButton b28;
    @FXML private ToggleButton b29;
    @FXML private ToggleButton b30;
    @FXML private ToggleButton b31;
    @FXML private ToggleButton b32;
    @FXML private ToggleButton b33;
    @FXML private ToggleButton b34;
    @FXML private ToggleButton b35;
    @FXML private ToggleButton b36;
    @FXML private ToggleButton b37;
    @FXML private ToggleButton b38;
    @FXML private ToggleButton b39;
    @FXML private ToggleButton b40;
    @FXML private ToggleButton b41;
    @FXML private ToggleButton b42;
    @FXML private ToggleButton b43;
    @FXML private ToggleButton b44;
    @FXML private ToggleButton b45;
    @FXML private ToggleButton b46;
    @FXML private ToggleButton b47;
    @FXML private ToggleButton b48;
    @FXML private ToggleButton b49;
    @FXML private ToggleButton b50;
    @FXML private ToggleButton b51;
    @FXML private ToggleButton b52;
    @FXML private ToggleButton b53;
    @FXML private ToggleButton b54;
    @FXML private ToggleButton b55;
    @FXML private ToggleButton b56;
    @FXML private ToggleButton b57;
    @FXML private ToggleButton b58;
    @FXML private ToggleButton b59;
    @FXML private ToggleButton b60;
    @FXML private ToggleButton b61;
    @FXML private ToggleButton b62;
    @FXML private ToggleButton b63;
    @FXML private ToggleButton b64;
    @FXML private ToggleButton b65;
    @FXML private ToggleButton b66;
    @FXML private ToggleButton b67;
    @FXML private ToggleButton b68;
    @FXML private ToggleButton b69;
    @FXML private ToggleButton b70;
    @FXML private ToggleButton b71;
    @FXML private ToggleButton b72;
    @FXML private ToggleButton b73;
    @FXML private ToggleButton b74;
    @FXML private ToggleButton b75;
    @FXML private ToggleButton b76;
    @FXML private ToggleButton b77;
    @FXML private ToggleButton b78;
    @FXML private ToggleButton b79;
    @FXML private ToggleButton b80;
    @FXML private ToggleButton b81;
    @FXML private ToggleButton b82;
    @FXML private ToggleButton b83;
    @FXML private ToggleButton b84;
    @FXML private ToggleButton b85;
    @FXML private ToggleButton b86;
    @FXML private ToggleButton b87;
    @FXML private ToggleButton b88;
    @FXML private ToggleButton b89;
    @FXML private ToggleButton b90;
    @FXML private ToggleButton b91;
    @FXML private ToggleButton b92;
    @FXML private ToggleButton b93;
    @FXML private ToggleButton b94;
    @FXML private ToggleButton b95;
    @FXML private ToggleButton b96;
    @FXML private ToggleButton b97;
    @FXML private ToggleButton b98;
    @FXML private ToggleButton b99;
    @FXML private ToggleButton b100;
    @FXML private ToggleButton b101;
    @FXML private ToggleButton b102;
    @FXML private ToggleButton b103;
    @FXML private ToggleButton b104;
    @FXML private ToggleButton b105;
    @FXML private ToggleButton b106;
    @FXML private ToggleButton b107;
    @FXML private ToggleButton b108;
    @FXML private ToggleButton b109;
    @FXML private ToggleButton b110;
    @FXML private ToggleButton b111;
    @FXML private ToggleButton b112;
    @FXML private ToggleButton b113;
    @FXML private ToggleButton b114;
    @FXML private ToggleButton b115;
    @FXML private ToggleButton b116;
    @FXML private ToggleButton b117;
    @FXML private ToggleButton b118;

    //mouseEvent for each element
    public void clickedH1(MouseEvent mouseEvent) throws IOException {
        displayElement(0);
        b1.setSelected(true);
    }
    public void clickedHe2(MouseEvent mouseEvent) throws IOException {
        displayElement(1);
        b2.setSelected(true);
    }
    public void clickedLi3(MouseEvent mouseEvent) throws IOException {
        displayElement(2);
        b3.setSelected(true);
    }
    public void clickedBe4(MouseEvent mouseEvent) throws IOException {
        displayElement(3);
        b4.setSelected(true);
    }
    public void clickedB5(MouseEvent mouseEvent) throws IOException {
        displayElement(4);
        b5.setSelected(true);
    }
    public void clickedC6(MouseEvent mouseEvent) throws IOException {
        displayElement(5);
        b6.setSelected(true);
    }
    public void clickedN7(MouseEvent mouseEvent) throws IOException {
        displayElement(6);
        b7.setSelected(true);
    }
    public void clickedO8(MouseEvent mouseEvent) throws IOException {
        displayElement(7);
        b8.setSelected(true);
    }
    public void clickedF9(MouseEvent mouseEvent) throws IOException {
        displayElement(8);
        b9.setSelected(true);
    }
    public void clickedNe10(MouseEvent mouseEvent) throws IOException {
        displayElement(9);
        b10.setSelected(true);
    }
    public void clickedNa11(MouseEvent mouseEvent) throws IOException {
        displayElement(10);
        b11.setSelected(true);
    }
    public void clickedMg12(MouseEvent mouseEvent) throws IOException {
        displayElement(11);
        b12.setSelected(true);
    }
    public void clickedAl13(MouseEvent mouseEvent) throws IOException {
        displayElement(12);
        b13.setSelected(true);
    }
    public void clickedSi14(MouseEvent mouseEvent) throws IOException {
        displayElement(13);
        b14.setSelected(true);
    }
    public void clickedP15(MouseEvent mouseEvent) throws IOException {
        displayElement(14);
        b15.setSelected(true);
    }
    public void clickedS16(MouseEvent mouseEvent) throws IOException {
        displayElement(15);
        b16.setSelected(true);
    }
    public void clickedCl17(MouseEvent mouseEvent) throws IOException {
        displayElement(16);
        b17.setSelected(true);
    }
    public void clickedAr18(MouseEvent mouseEvent) throws IOException {
        displayElement(17);
        b18.setSelected(true);
    }
    public void clickedK19(MouseEvent mouseEvent) throws IOException {
        displayElement(18);
        b19.setSelected(true);
    }
    public void clickedCa20(MouseEvent mouseEvent) throws IOException {
        displayElement(19);
        b20.setSelected(true);
    }
    public void clickedSc21(MouseEvent mouseEvent) throws IOException {
        displayElement(20);
        b21.setSelected(true);
    }
    public void clickedTi22(MouseEvent mouseEvent) throws IOException {
        displayElement(21);
        b22.setSelected(true);
    }
    public void clickedV23(MouseEvent mouseEvent) throws IOException {
        displayElement(22);
        b23.setSelected(true);
    }
    public void clickedCr24(MouseEvent mouseEvent) throws IOException {
        displayElement(23);
        b24.setSelected(true);
    }
    public void clickedMn25(MouseEvent mouseEvent) throws IOException {
        displayElement(24);
        b25.setSelected(true);
    }
    public void clickedFe26(MouseEvent mouseEvent) throws IOException {
        displayElement(25);
        b26.setSelected(true);
    }
    public void clickedCo27(MouseEvent mouseEvent) throws IOException {
        displayElement(26);
        b27.setSelected(true);
    }
    public void clickedNi28(MouseEvent mouseEvent) throws IOException {
        displayElement(27);
        b28.setSelected(true);
    }
    public void clickedCu29(MouseEvent mouseEvent) throws IOException {
        displayElement(28);
        b29.setSelected(true);
    }
    public void clickedZn30(MouseEvent mouseEvent) throws IOException {
        displayElement(29);
        b30.setSelected(true);
    }
    public void clickedGa31(MouseEvent mouseEvent) throws IOException {
        displayElement(30);
        b31.setSelected(true);
    }
    public void clickedGe32(MouseEvent mouseEvent) throws IOException {
        displayElement(31);
        b32.setSelected(true);
    }
    public void clickedAs33(MouseEvent mouseEvent) throws IOException {
        displayElement(32);
        b33.setSelected(true);
    }
    public void clickedSe34(MouseEvent mouseEvent) throws IOException {
        displayElement(33);
        b34.setSelected(true);
    }
    public void clickedBr35(MouseEvent mouseEvent) throws IOException {
        displayElement(34);
        b35.setSelected(true);
    }
    public void clickedKr36(MouseEvent mouseEvent) throws IOException {
        displayElement(35);
        b36.setSelected(true);
    }
    public void clickedRb37(MouseEvent mouseEvent) throws IOException {
        displayElement(36);
        b37.setSelected(true);
    }
    public void clickedSr38(MouseEvent mouseEvent) throws IOException {
        displayElement(37);
        b38.setSelected(true);
    }
    public void clickedY39(MouseEvent mouseEvent) throws IOException {
        displayElement(38);
        b39.setSelected(true);
    }
    public void clickedZr40(MouseEvent mouseEvent) throws IOException {
        displayElement(39);
        b40.setSelected(true);
    }
    public void clickedNb41(MouseEvent mouseEvent) throws IOException {
        displayElement(40);
        b41.setSelected(true);
    }
    public void clickedMo42(MouseEvent mouseEvent) throws IOException {
        displayElement(41);
        b42.setSelected(true);
    }
    public void clickedTc43(MouseEvent mouseEvent) throws IOException {
        displayElement(42);
        b43.setSelected(true);
    }
    public void clickedRu44(MouseEvent mouseEvent) throws IOException {
        displayElement(43);
        b44.setSelected(true);
    }
    public void clickedRh45(MouseEvent mouseEvent) throws IOException {
        displayElement(44);
        b45.setSelected(true);
    }
    public void clickedPd46(MouseEvent mouseEvent) throws IOException {
        displayElement(45);
        b46.setSelected(true);
    }
    public void clickedAg47(MouseEvent mouseEvent) throws IOException {
        displayElement(46);
        b47.setSelected(true);
    }
    public void clickedCd48(MouseEvent mouseEvent) throws IOException {
        displayElement(47);
        b48.setSelected(true);
    }
    public void clickedIn49(MouseEvent mouseEvent) throws IOException {
        displayElement(48);
        b49.setSelected(true);
    }
    public void clickedSn50(MouseEvent mouseEvent) throws IOException {
        displayElement(49);
        b50.setSelected(true);
    }
    public void clickedSb51(MouseEvent mouseEvent) throws IOException {
        displayElement(50);
        b51.setSelected(true);
    }
    public void clickedTe52(MouseEvent mouseEvent) throws IOException {
        displayElement(51);
        b52.setSelected(true);
    }
    public void clickedI53(MouseEvent mouseEvent) throws IOException {
        displayElement(52);
        b53.setSelected(true);
    }
    public void clickedXe54(MouseEvent mouseEvent) throws IOException {
        displayElement(53);
        b54.setSelected(true);
    }
    public void clickedCs55(MouseEvent mouseEvent) throws IOException {
        displayElement(54);
        b55.setSelected(true);
    }
    public void clickedBa56(MouseEvent mouseEvent) throws IOException {
        displayElement(55);
        b56.setSelected(true);
    }
    public void clickedLa57(MouseEvent mouseEvent) throws IOException {
        displayElement(56);
        b57.setSelected(true);
    }
    public void clickedCe58(MouseEvent mouseEvent) throws IOException {
        displayElement(57);
        b58.setSelected(true);
    }
    public void clickedPr59(MouseEvent mouseEvent) throws IOException {
        displayElement(58);
        b59.setSelected(true);
    }
    public void clickedNd60(MouseEvent mouseEvent) throws IOException {
        displayElement(59);
        b60.setSelected(true);
    }
    public void clickedPm61(MouseEvent mouseEvent) throws IOException {
        displayElement(60);
        b61.setSelected(true);
    }
    public void clickedSm62(MouseEvent mouseEvent) throws IOException {
        displayElement(61);
        b62.setSelected(true);
    }
    public void clickedEu63(MouseEvent mouseEvent) throws IOException {
        displayElement(62);
        b63.setSelected(true);
    }
    public void clickedGd64(MouseEvent mouseEvent) throws IOException {
        displayElement(63);
        b64.setSelected(true);
    }
    public void clickedTb65(MouseEvent mouseEvent) throws IOException {
        displayElement(64);
        b65.setSelected(true);
    }
    public void clickedDy66(MouseEvent mouseEvent) throws IOException {
        displayElement(65);
        b66.setSelected(true);
    }
    public void clickedHo67(MouseEvent mouseEvent) throws IOException {
        displayElement(66);
        b67.setSelected(true);
    }
    public void clickedEr68(MouseEvent mouseEvent) throws IOException {
        displayElement(67);
        b68.setSelected(true);
    }
    public void clickedTm69(MouseEvent mouseEvent) throws IOException {
        displayElement(68);
        b69.setSelected(true);
    }
    public void clickedYb70(MouseEvent mouseEvent) throws IOException {
        displayElement(69);
        b70.setSelected(true);
    }
    public void clickedLu71(MouseEvent mouseEvent) throws IOException {
        displayElement(70);
        b71.setSelected(true);
    }
    public void clickedHf72(MouseEvent mouseEvent) throws IOException {
        displayElement(71);
        b72.setSelected(true);
    }
    public void clickedTa73(MouseEvent mouseEvent) throws IOException {
        displayElement(72);
        b73.setSelected(true);
    }
    public void clickedW74(MouseEvent mouseEvent) throws IOException {
        displayElement(73);
        b74.setSelected(true);
    }
    public void clickedRe75(MouseEvent mouseEvent) throws IOException {
        displayElement(74);
        b75.setSelected(true);
    }
    public void clickedOs76(MouseEvent mouseEvent) throws IOException {
        displayElement(75);
        b76.setSelected(true);
    }
    public void clickedIr77(MouseEvent mouseEvent) throws IOException {
        displayElement(76);
        b77.setSelected(true);
    }
    public void clickedPt78(MouseEvent mouseEvent) throws IOException {
        displayElement(77);
        b78.setSelected(true);
    }
    public void clickedAu79(MouseEvent mouseEvent) throws IOException {
        displayElement(78);
        b79.setSelected(true);
    }
    public void clickedHg80(MouseEvent mouseEvent) throws IOException {
        displayElement(79);
        b80.setSelected(true);
    }
    public void clickedTi81(MouseEvent mouseEvent) throws IOException {
        displayElement(80);
        b81.setSelected(true);
    }
    public void clickedPb82(MouseEvent mouseEvent) throws IOException {
        displayElement(81);
        b82.setSelected(true);
    }
    public void clickedBi83(MouseEvent mouseEvent) throws IOException {
        displayElement(82);
        b83.setSelected(true);
    }
    public void clickedPo84(MouseEvent mouseEvent) throws IOException {
        displayElement(83);
        b84.setSelected(true);
    }
    public void clickedAt85(MouseEvent mouseEvent) throws IOException {
        displayElement(84);
        b85.setSelected(true);
    }
    public void clickedRn86(MouseEvent mouseEvent) throws IOException {
        displayElement(85);
        b86.setSelected(true);
    }
    public void clickedFr87(MouseEvent mouseEvent) throws IOException {
        displayElement(86);
        b87.setSelected(true);
    }
    public void clickedRa88(MouseEvent mouseEvent) throws IOException {
        displayElement(87);
        b88.setSelected(true);
    }
    public void clickedAc89(MouseEvent mouseEvent) throws IOException {
        displayElement(88);
        b89.setSelected(true);
    }
    public void clickedTh90(MouseEvent mouseEvent) throws IOException {
        displayElement(89);
        b90.setSelected(true);
    }
    public void clickedPa91(MouseEvent mouseEvent) throws IOException {
        displayElement(90);
        b91.setSelected(true);
    }
    public void clickedU92(MouseEvent mouseEvent) throws IOException {
        displayElement(91);
        b92.setSelected(true);
    }
    public void clickedNp93(MouseEvent mouseEvent) throws IOException {
        displayElement(92);
        b93.setSelected(true);
    }
    public void clickedPu94(MouseEvent mouseEvent) throws IOException {
        displayElement(93);
        b94.setSelected(true);
    }
    public void clickedAm95(MouseEvent mouseEvent) throws IOException {
        displayElement(94);
        b95.setSelected(true);
    }
    public void clickedCm96(MouseEvent mouseEvent) throws IOException {
        displayElement(95);
        b96.setSelected(true);
    }
    public void clickedBk97(MouseEvent mouseEvent) throws IOException {
        displayElement(96);
        b97.setSelected(true);
    }
    public void clickedCf98(MouseEvent mouseEvent) throws IOException {
        displayElement(97);
        b98.setSelected(true);
    }
    public void clickedEs99(MouseEvent mouseEvent) throws IOException {
        displayElement(98);
        b99.setSelected(true);
    }
    public void clickedFm100(MouseEvent mouseEvent) throws IOException {
        displayElement(99);
        b100.setSelected(true);
    }
    public void clickedMd101(MouseEvent mouseEvent) throws IOException {
        displayElement(100);
        b101.setSelected(true);
    }
    public void clickedNo102(MouseEvent mouseEvent) throws IOException {
        displayElement(101);
        b102.setSelected(true);
    }
    public void clickedLr103(MouseEvent mouseEvent) throws IOException {
        displayElement(102);
        b103.setSelected(true);
    }
    public void clickedRf104(MouseEvent mouseEvent) throws IOException {
        displayElement(103);
        b104.setSelected(true);
    }
    public void clickedDb105(MouseEvent mouseEvent) throws IOException {
        displayElement(104);
        b105.setSelected(true);
    }
    public void clickedSg106(MouseEvent mouseEvent) throws IOException {
        displayElement(105);
        b106.setSelected(true);
    }
    public void clickedBh107(MouseEvent mouseEvent) throws IOException {
        displayElement(106);
        b107.setSelected(true);
    }
    public void clickedHs108(MouseEvent mouseEvent) throws IOException {
        displayElement(107);
        b108.setSelected(true);
    }
    public void clickedMt109(MouseEvent mouseEvent) throws IOException {
        displayElement(108);
        b109.setSelected(true);
    }
    public void clickedDs110(MouseEvent mouseEvent) throws IOException {
        displayElement(109);
        b110.setSelected(true);
    }
    public void clickedRg111(MouseEvent mouseEvent) throws IOException {
        displayElement(110);
        b111.setSelected(true);
    }
    public void clickedCn112(MouseEvent mouseEvent) throws IOException {
        displayElement(111);
        b112.setSelected(true);
    }
    public void clickedNh113(MouseEvent mouseEvent) throws IOException {
        displayElement(112);
        b113.setSelected(true);
    }
    public void clickedFl114(MouseEvent mouseEvent) throws IOException {
        displayElement(113);
        b114.setSelected(true);
    }
    public void clickedMc115(MouseEvent mouseEvent) throws IOException {
        displayElement(114);
        b115.setSelected(true);
    }
    public void clickedLv116(MouseEvent mouseEvent) throws IOException {
        displayElement(115);
        b116.setSelected(true);
    }
    public void clickedTs117(MouseEvent mouseEvent) throws IOException {
        displayElement(116);
        b117.setSelected(true);
    }
    public void clickedOg118(MouseEvent mouseEvent) throws IOException {
        displayElement(117);
        b118.setSelected(true);
    }

    //Method that displays the element's information into the information box
    public void displayElement (int index) throws IOException {
        String specificLineInfo = Files.readAllLines(Paths.get("src/resources/table.txt")).get(index);
        String[] splitLineInfo = specificLineInfo.split(",");

        elementAtomicNumText.setText(splitLineInfo[0]);
        elementSymbolText.setText(splitLineInfo[1]);
        elementNameText.setText(splitLineInfo[2]);
        elementAtomicMassText.setText(splitLineInfo[3]);

        //If there is no value, do not show units
        if (splitLineInfo[4].equals("Unknown"))
            elementMeltPtText.setText(splitLineInfo[4]);
        else
            elementMeltPtText.setText(splitLineInfo[4] + " K");

        if (splitLineInfo[5].equals("Unknown"))
            elementBoilPtText.setText(splitLineInfo[5]);
        else
            elementBoilPtText.setText(splitLineInfo[5] + " K");
    }
}
