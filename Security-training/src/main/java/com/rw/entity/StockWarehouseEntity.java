package com.rw.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;

/**
 * 库房
 * @TableName STOCK_WAREHOUSE
 */
@TableName(value ="STOCK_WAREHOUSE")
public class StockWarehouseEntity implements Serializable {
    /**
     * ID
     */
    @TableId(value = "ID")
    private String id;

    /**
     * 创建时间
     */
    @TableField(value = "CREATOR_TIME")
    private Date creatorTime;

    /**
     * 创建人
     */
    @TableField(value = "CREATOR")
    private String creator;

    /**
     * 修改时间
     */
    @TableField(value = "UPDATE_TIME")
    private Date updateTime;

    /**
     * 修改人
     */
    @TableField(value = "UPDATER")
    private String updater;

    /**
     * 组织机构ID

     */
    @TableField(value = "ORGANIZATION_ID")
    private String organizationId;

    /**
     * 业务组ID

     */
    @TableField(value = "BUSINESS_GROUP_ID")
    private String businessGroupId;

    /**
     * 库房名称

     */
    @TableField(value = "WAREHOUSE_NAME")
    private String warehouseName;

    /**
     * 内外部标识

     */
    @TableField(value = "INT_EXT_FLAG")
    private String intExtFlag;

    /**
     * 备注
     */
    @TableField(value = "REMARK")
    private String remark;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    public String getId() {
        return id;
    }

    /**
     * ID
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 创建时间
     */
    public Date getCreatorTime() {
        return creatorTime;
    }

    /**
     * 创建时间
     */
    public void setCreatorTime(Date creatorTime) {
        this.creatorTime = creatorTime;
    }

    /**
     * 创建人
     */
    public String getCreator() {
        return creator;
    }

    /**
     * 创建人
     */
    public void setCreator(String creator) {
        this.creator = creator;
    }

    /**
     * 修改时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 修改时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 修改人
     */
    public String getUpdater() {
        return updater;
    }

    /**
     * 修改人
     */
    public void setUpdater(String updater) {
        this.updater = updater;
    }

    /**
     * 组织机构ID

     */
    public String getOrganizationId() {
        return organizationId;
    }

    /**
     * 组织机构ID

     */
    public void setOrganizationId(String organizationId) {
        this.organizationId = organizationId;
    }

    /**
     * 业务组ID

     */
    public String getBusinessGroupId() {
        return businessGroupId;
    }

    /**
     * 业务组ID

     */
    public void setBusinessGroupId(String businessGroupId) {
        this.businessGroupId = businessGroupId;
    }

    /**
     * 库房名称

     */
    public String getWarehouseName() {
        return warehouseName;
    }

    /**
     * 库房名称

     */
    public void setWarehouseName(String warehouseName) {
        this.warehouseName = warehouseName;
    }

    /**
     * 内外部标识

     */
    public String getIntExtFlag() {
        return intExtFlag;
    }

    /**
     * 内外部标识

     */
    public void setIntExtFlag(String intExtFlag) {
        this.intExtFlag = intExtFlag;
    }

    /**
     * 备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 备注
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        StockWarehouseEntity other = (StockWarehouseEntity) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getCreatorTime() == null ? other.getCreatorTime() == null : this.getCreatorTime().equals(other.getCreatorTime()))
            && (this.getCreator() == null ? other.getCreator() == null : this.getCreator().equals(other.getCreator()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getUpdater() == null ? other.getUpdater() == null : this.getUpdater().equals(other.getUpdater()))
            && (this.getOrganizationId() == null ? other.getOrganizationId() == null : this.getOrganizationId().equals(other.getOrganizationId()))
            && (this.getBusinessGroupId() == null ? other.getBusinessGroupId() == null : this.getBusinessGroupId().equals(other.getBusinessGroupId()))
            && (this.getWarehouseName() == null ? other.getWarehouseName() == null : this.getWarehouseName().equals(other.getWarehouseName()))
            && (this.getIntExtFlag() == null ? other.getIntExtFlag() == null : this.getIntExtFlag().equals(other.getIntExtFlag()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCreatorTime() == null) ? 0 : getCreatorTime().hashCode());
        result = prime * result + ((getCreator() == null) ? 0 : getCreator().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getUpdater() == null) ? 0 : getUpdater().hashCode());
        result = prime * result + ((getOrganizationId() == null) ? 0 : getOrganizationId().hashCode());
        result = prime * result + ((getBusinessGroupId() == null) ? 0 : getBusinessGroupId().hashCode());
        result = prime * result + ((getWarehouseName() == null) ? 0 : getWarehouseName().hashCode());
        result = prime * result + ((getIntExtFlag() == null) ? 0 : getIntExtFlag().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", creatorTime=").append(creatorTime);
        sb.append(", creator=").append(creator);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", updater=").append(updater);
        sb.append(", organizationId=").append(organizationId);
        sb.append(", businessGroupId=").append(businessGroupId);
        sb.append(", warehouseName=").append(warehouseName);
        sb.append(", intExtFlag=").append(intExtFlag);
        sb.append(", remark=").append(remark);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}