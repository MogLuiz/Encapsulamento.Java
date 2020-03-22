package aula06;
public class ControleRemoto implements Controlador{
    //Atributos
    private int volume;
    private boolean ligado;
    private boolean tocando;
    //Metodos Especiais
    public ControleRemoto() {
        this.volume = 50;
        this.ligado = true;
    }
    public int getVolume(){
        return volume;
    }
    public void setVolume(int v){
        this.volume = v;
    }
    public boolean getLigado(){
        return ligado;
    }
    public void setLigado(boolean l) {
        this.ligado = l;
    }
    public boolean getTocando(){
        return tocando;
    }
    public void setTocando(boolean t){
        this.tocando = t;
    }
    //Metodos Abstratos
    @Override
    public void ligar() {
        setLigado(true);
    }
    @Override
    public void desligar() {
        setLigado(false);
    }
    @Override
    public void abriMenu() {
        System.out.println("***** Menu *****");
        System.out.println("Está Ligado ?" + this.getLigado());
        System.out.println("Está Tocando ?" + this.getTocando());
        System.out.print("Volume : " + this.getVolume());
        for (int i = 0 ; i<= this.getVolume(); i+=10) {
            System.out.print("|");
        }
    }
    @Override
    public void fecharMenu() {
        System.out.println("Fechando o Menu ");
    }

    @Override
    public void maisVolume() {
        if (this.getLigado()) {
            setVolume(this.getVolume()+1);
        }
    }
    @Override
    public void menosVolume() {
        if (this.getLigado() && this.getVolume() > 0) {
            setVolume(this.getVolume()-1);
        }
    }
    @Override
    public void ligarMudo() {
        if (this.getLigado() && this.getVolume() > 0) {
            this.setVolume(0);
        }
    }
    @Override
    public void desligarMudo() {
        if (this.getLigado() && this.getVolume() == 0) {
            this.setVolume(50);
        }
    }
    @Override
    public void play() {
        if (this.getLigado() && !(this.getTocando())) {
            this.setTocando(true);
        }
    }
    @Override
    public void pause() {
        if (this.getLigado() && this.getTocando()) {
            this.setTocando(false);
        }
    }
}
