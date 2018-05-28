package ThemePark.Interfaces;

import ThemePark.Visitors.Visitor;

public interface IRestrictable {
    public Boolean isAllowedTo(Visitor visitor);
}
