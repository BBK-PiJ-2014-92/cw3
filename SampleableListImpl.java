public class SampleableListImpl extends AbstractList implements SampleableList {
	public SampleableListImpl(List listType) {
		super(listType);
	}

	public SampleableList sample() {
		List list = new ArrayList();
		SampleableList sample = new SampleableListImpl (list);
		if(isEmpty()) {
			return sample;
		}
		for (int i = 0; i < this.size(); i = i+2) {
			Object item = this.get(i).getReturnValue();
			sample.add(item);
		}
		return sample;
	}
}