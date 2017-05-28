
function LoggedUserClass() {
    var _isLoggedIn = false;
    var _userType = null;
    this.IsLoggedIn = function() {
        return _isLoggedIn;
    }
    this.GetUserType = function() {
        return _userType;
    }
    this.SetLoggedIn = function(isLoggedIn, userType) {
        _isLoggedIn = isLoggedIn;
        _userType = userType;
    }

    
}

var LoggedUser = new LoggedUserClass();

export default LoggedUser;