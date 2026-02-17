require "selenium-webdriver"

driver = Selenium::WebDriver.for :chrome
driver.navigate.to "http://google.com"

element = driver.find_element(name: 'q')
element.click
element.send_keys "Hello from Slinky's Webdriver!"
element.submit

sleep 2

driver.quit