public class SampleableListImpl extends AbstractList implements SampleableList {
	public SampleableListImpl(List listType) {
		super(listType);
	}

	public SampleableList sample() {
		SampleableList sample = new SampleableListImpl (listType);
		for (int i = 0; i < size(); i += 2) {
			sample.add(get(i));
		}
		return sample;
	}
}