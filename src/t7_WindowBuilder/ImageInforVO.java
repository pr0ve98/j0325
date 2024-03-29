package t7_WindowBuilder;

public class ImageInforVO {
	private int idx;
	private String name;
	private String img;
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	
	@Override
	public String toString() {
		return "ImageInforVO [idx=" + idx + ", name=" + name + ", img=" + img + "]";
	}
}
