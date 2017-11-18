package pl.legalnyplener.planktrzon;

public class Poster {
    private int _id;
    private String _name;
    private String _info;
    private String _city;
    private String _adress;
    private String _start_date;
    private String _end_date;
    private String _start_time;
    private String _end_time;
    private String _imgURL;
    private String _infoURL;
    private String _facebookURL;
    private String _ticketURL;

    public Poster(){

    }

    public Poster(int _id, String _name, String _info, String _city, String _adress, String _start_date, String _end_date, String _start_time, String _end_time, String _imgURL, String _infoURL, String _facebookURL, String _ticketURL) {
        this._id = _id;
        this._name = _name;
        this._info = _info;
        this._city = _city;
        this._adress = _adress;
        this._start_date = _start_date;
        this._end_date = _end_date;
        this._start_time = _start_time;
        this._end_time = _end_time;
        this._imgURL = _imgURL;
        this._infoURL = _infoURL;
        this._facebookURL = _facebookURL;
        this._ticketURL = _ticketURL;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String get_name() {
        return _name;
    }

    public void set_name(String _name) {
        this._name = _name;
    }

    public String get_info() {
        return _info;
    }

    public void set_info(String _info) {
        this._info = _info;
    }

    public String get_city() {
        return _city;
    }

    public void set_city(String _city) {
        this._city = _city;
    }

    public String get_adress() {
        return _adress;
    }

    public void set_adress(String _adress) {
        this._adress = _adress;
    }

    public String get_start_date() {
        return _start_date;
    }

    public void set_start_date(String _start_date) {
        this._start_date = _start_date;
    }

    public String get_end_date() {
        return _end_date;
    }

    public void set_end_date(String _end_date) {
        this._end_date = _end_date;
    }

    public String get_start_time() {
        return _start_time;
    }

    public void set_start_time(String _start_time) {
        this._start_time = _start_time;
    }

    public String get_end_time() {
        return _end_time;
    }

    public void set_end_time(String _end_time) {
        this._end_time = _end_time;
    }

    public String get_imgURL() {
        return _imgURL;
    }

    public void set_imgURL(String _imgURL) {
        this._imgURL = _imgURL;
    }

    public String get_infoURL() {
        return _infoURL;
    }

    public void set_infoURL(String _infoURL) {
        this._infoURL = _infoURL;
    }

    public String get_facebookURL() {
        return _facebookURL;
    }

    public void set_facebookURL(String _facebookURL) {
        this._facebookURL = _facebookURL;
    }

    public String get_ticketURL() {
        return _ticketURL;
    }

    public void set_ticketURL(String _ticketURL) {
        this._ticketURL = _ticketURL;
    }
}
