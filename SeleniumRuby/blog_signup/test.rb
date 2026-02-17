require "selenium-webdriver"
require "rspec"
require_relative "signup_page.rb"
require_relative "users_page.rb"

timestamp = Time.now.to_i
username = "slinky#{timestamp}"
email = "slinkysan#{timestamp}@gmail.com"
password = "slinkypass"
expected_banner_text = "Welcome to the alpha blog slinky#{timestamp}"

# TEST: Sign up for blog
describe "Blog application" do
  describe "when signing up a new user"	do
  	it "creates a new user account successfully" do
	    @driver = Selenium::WebDriver.for :chrome
        
        # Go to signup form
        @driver.navigate.to "https://selenium-blog.herokuapp.com/signup"
		
        # Fill out and submit form
        signup = SignupPage.new(@driver)
        signup.enter_username(username)
        signup.enter_email_address(email)
        signup.enter_password(password)
        signup.submit_form()

		# Confirm user is signed up successfully
        users = UsersPage.new(@driver)
        banner_text = users.get_banner_text()
        expect(banner_text).to eq(expected_banner_text)

        sleep 2
		
        @driver.quit
	  end
  end
end