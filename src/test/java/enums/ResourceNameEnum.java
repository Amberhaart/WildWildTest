package enums;

public enum ResourceNameEnum {
  PINEAPPLE("pineapple"),
  COIN("coin");

  private String resourceName;

  ResourceNameEnum(String resourceName) {
    this.resourceName = resourceName;
  }

  public String getResourceName() {
    return resourceName;
  }
}